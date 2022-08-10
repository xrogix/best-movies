package com.igor.bestmovies.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.igor.bestmovies.utils.NoInternetException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    private val _progress = MutableLiveData<ProgressBarVisibility>()
    val progress : LiveData<ProgressBarVisibility>
        get() = _progress

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    private val handler = CoroutineExceptionHandler { _, throwable ->
        _error.value = throwable.message
    }

    protected fun launchViewModel(body: suspend () -> Unit) = viewModelScope.launch(handler) {
        _progress.postValue(ProgressBarVisibility.ProgressBarVisible)
        try {
            body.invoke()
            _progress.postValue(ProgressBarVisibility.ProgressBarGone)
        } catch (e: NoInternetException) {
            _progress.postValue(ProgressBarVisibility.ProgressBarGone)
            _error.value = e.message
        }
    }
}

sealed class ProgressBarVisibility {
    object ProgressBarVisible: ProgressBarVisibility()
    object ProgressBarGone: ProgressBarVisibility()
}