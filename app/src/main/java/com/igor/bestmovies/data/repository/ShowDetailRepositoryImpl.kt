package com.igor.bestmovies.data.repository

import com.igor.bestmovies.domain.datasource.Datasource
import com.igor.bestmovies.domain.repository.ShowDetailRepository
import javax.inject.Inject

class ShowDetailRepositoryImpl @Inject constructor(
    private val datasource: Datasource
) : ShowDetailRepository {
    override suspend fun fetchAsync(id: Int) =
        datasource.fetchAsync(id)
}