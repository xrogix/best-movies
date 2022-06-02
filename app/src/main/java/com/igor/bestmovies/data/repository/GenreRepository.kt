package com.igor.bestmovies.data.repository

import com.igor.bestmovies.domain.model.GenreResponse

interface GenreRepository {
    suspend fun fetchGenreAsync() : GenreResponse?
}