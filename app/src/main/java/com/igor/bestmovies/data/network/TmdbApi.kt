package com.igor.bestmovies.data.network

import com.igor.bestmovies.data.model.GenreListResponse
import com.igor.bestmovies.data.model.ShowResponse
import com.igor.bestmovies.data.model.PopularShowResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface TmdbApi {
    @GET("$TMDB_API_VERSION/genre/tv/list")
    suspend fun fetchGenresAsync(): GenreListResponse?

    @GET("$TMDB_API_VERSION/tv/popular")
    suspend fun fetchPopularShowsAsync(): PopularShowResponse?

    @GET("$TMDB_API_VERSION/tv/{tv_id}")
    suspend fun fetchShowAsync(
        @Path("tv_id") id: Int
    ): ShowResponse?

    companion object {
        private const val TMDB_API_VERSION = "3"
        const val TMDB_BASE_URL = "https://api.themoviedb.org"
        const val TMDB_API_QUERY = "api_key"
    }
}