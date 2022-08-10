package com.igor.bestmovies.domain.datasource

import com.igor.bestmovies.domain.model.Genre
import com.igor.bestmovies.domain.model.PopularShow
import com.igor.bestmovies.domain.model.Show

interface Datasource {
    suspend fun fetchGenreAsync(): List<Genre>

    suspend fun fetchPopularShowsAsync(): PopularShow?

    suspend fun fetchAsync(id: Int): Show?
}