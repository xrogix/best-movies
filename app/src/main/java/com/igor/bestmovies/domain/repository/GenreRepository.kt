package com.igor.bestmovies.domain.repository

import com.igor.bestmovies.domain.model.Genre

interface GenreRepository {
    suspend fun fetchGenreAsync() : List<Genre>
}