package com.igor.bestmovies.data.datasource

import com.igor.bestmovies.data.network.TmdbApi
import javax.inject.Inject

class RemoteDatasource @Inject constructor(
    private val api: TmdbApi
) : Datasource {
    override suspend fun fetchGenreAsync() =
        api.fetchGenresAsync()

    override suspend fun fetchPopularShowsAsync() =
        api.fetchPopularShowsAsync()

    override suspend fun fetchAsync(id: Int) =
        api.fetchShowAsync(id)
}