package com.igor.bestmovies.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.igor.bestmovies.utils.NoInternetException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    private val handler = CoroutineExceptionHandler { _, throwable ->
        _error.value = throwable.message
    }

    protected fun launchViewModel(body: suspend () -> Unit) = viewModelScope.launch(handler) {
        try {
            body.invoke()
        } catch (e: NoInternetException) {
            _error.value = e.message
        }
    }
}