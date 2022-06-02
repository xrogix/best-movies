package com.igor.bestmovies.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.igor.bestmovies.domain.model.Show
import com.igor.bestmovies.domain.usecase.GetGenre
import com.igor.bestmovies.domain.usecase.GetPopularShow
import com.igor.bestmovies.domain.usecase.GetShowDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGenre: GetGenre,
    private val getPopularShow: GetPopularShow,
    private val getShowDetail: GetShowDetail
) : BaseViewModel() {

    private val _show = MutableLiveData<List<Show>>()
    val show : LiveData<List<Show>>
        get() = _show

    private val _detail = MutableLiveData<Show>()
    val detail : LiveData<Show>
        get() = _detail

    fun loadShows() {
        launchViewModel {
            val genres = getGenre()
            _show.value = getPopularShow(genres)
        }
    }

    fun getShow(id: Int) {
        launchViewModel {
            _detail.value = getShowDetail(id)
        }
    }

}