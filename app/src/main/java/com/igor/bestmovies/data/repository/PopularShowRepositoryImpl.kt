package com.igor.bestmovies.data.repository

import com.igor.bestmovies.data.datasource.Datasource
import javax.inject.Inject

class PopularShowRepositoryImpl @Inject constructor(
    private val datasource: Datasource
) : PopularShowRepository {
    override suspend fun fetchPopularShowsAsync() =
        datasource.fetchPopularShowsAsync()
}