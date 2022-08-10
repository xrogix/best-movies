package com.igor.bestmovies.data.datasource

import com.igor.bestmovies.data.network.TmdbApi
import com.igor.bestmovies.domain.datasource.Datasource
import javax.inject.Inject

class RemoteDatasource @Inject constructor(
    private val api: TmdbApi
) : Datasource {
    override suspend fun fetchGenreAsync() =
        api.fetchGenresAsync()?.toMapDomain() ?: emptyList()

    override suspend fun fetchPopularShowsAsync() =
        api.fetchPopularShowsAsync()?.toMapDomain()

    override suspend fun fetchAsync(id: Int) =
        api.fetchShowAsync(id)?.toMapDomain()
}