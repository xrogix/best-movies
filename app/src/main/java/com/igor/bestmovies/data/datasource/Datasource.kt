package com.igor.bestmovies.data.datasource

import com.igor.bestmovies.domain.model.GenreResponse
import com.igor.bestmovies.domain.model.Show
import com.igor.bestmovies.domain.model.ShowResponse

interface Datasource {
    suspend fun fetchGenreAsync() : GenreResponse?

    suspend fun fetchPopularShowsAsync() : ShowResponse?

    suspend fun fetchAsync(id: Int) : Show?
}