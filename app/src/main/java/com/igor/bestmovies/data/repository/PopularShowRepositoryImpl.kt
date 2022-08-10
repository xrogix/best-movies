package com.igor.bestmovies.data.repository

import com.igor.bestmovies.domain.datasource.Datasource
import com.igor.bestmovies.domain.repository.PopularShowRepository
import javax.inject.Inject

class PopularShowRepositoryImpl @Inject constructor(
    private val datasource: Datasource
) : PopularShowRepository {
    override suspend fun fetchPopularShowsAsync() =
        datasource.fetchPopularShowsAsync()
}