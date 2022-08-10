package com.igor.bestmovies.data.repository

import com.igor.bestmovies.domain.datasource.Datasource
import com.igor.bestmovies.domain.repository.GenreRepository
import javax.inject.Inject

class GenreRepositoryImpl @Inject constructor(
    private val datasource: Datasource
) : GenreRepository {
    override suspend fun fetchGenreAsync() =
        datasource.fetchGenreAsync()
}