package com.igor.bestmovies.data.repository

import com.igor.bestmovies.data.datasource.Datasource
import javax.inject.Inject

class ShowDetailRepositoryImpl @Inject constructor(
    private val datasource: Datasource
) : ShowDetailRepository {
    override suspend fun fetchAsync(id: Int) =
        datasource.fetchAsync(id)
}