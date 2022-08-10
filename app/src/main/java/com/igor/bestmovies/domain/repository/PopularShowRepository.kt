package com.igor.bestmovies.domain.repository

import com.igor.bestmovies.domain.model.PopularShow

interface PopularShowRepository {
    suspend fun fetchPopularShowsAsync() : PopularShow?
}