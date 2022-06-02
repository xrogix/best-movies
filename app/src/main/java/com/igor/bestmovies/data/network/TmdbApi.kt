package com.igor.bestmovies.data.network

import com.igor.bestmovies.domain.model.GenreResponse
import com.igor.bestmovies.domain.model.Show
import com.igor.bestmovies.domain.model.ShowResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface TmdbApi {
    @GET("$TMDB_API_VERSION/genre/tv/list")
    suspend fun fetchGenresAsync(): GenreResponse?

    @GET("$TMDB_API_VERSION/tv/popular")
    suspend fun fetchPopularShowsAsync(): ShowResponse?

    @GET("$TMDB_API_VERSION/tv/{tv_id}")
    suspend fun fetchShowAsync(
        @Path("tv_id") id: Int
    ): Show?

    companion object {
        private const val TMDB_API_VERSION = "3"
        const val TMDB_BASE_URL = "https://api.themoviedb.org"
        const val TMDB_API_QUERY = "api_key"
    }
}