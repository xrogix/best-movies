package com.igor.bestmovies.data.repository

import com.igor.bestmovies.domain.model.ShowResponse

interface PopularShowRepository {
    suspend fun fetchPopularShowsAsync() : ShowResponse?
}