package com.igor.bestmovies.data.repository

import com.igor.bestmovies.di.IoDispatcher
import com.igor.bestmovies.domain.datasource.Datasource
import com.igor.bestmovies.domain.repository.GenreRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GenreRepositoryImpl @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val datasource: Datasource
) : GenreRepository {
    override suspend fun fetchGenreAsync() = withContext(dispatcher) {
        datasource.fetchGenreAsync()
    }
}