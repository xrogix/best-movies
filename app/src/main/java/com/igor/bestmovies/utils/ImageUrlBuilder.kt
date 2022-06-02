package com.igor.bestmovies.utils

import com.igor.bestmovies.BuildConfig
import com.igor.bestmovies.data.network.TmdbApi

object ImageUrlBuilder {

    private const val POSTER_URL = "https://image.tmdb.org/t/p/w154"
    private const val BACKDROP_URL = "https://image.tmdb.org/t/p/w780"

    fun buildPosterUrl(posterPath: String): String {
        return POSTER_URL + posterPath + "?${TmdbApi.TMDB_API_QUERY}=" + BuildConfig.TMDB_API_KEY
    }

    fun buildBackdropUrl(backdropPath: String): String {
        return BACKDROP_URL + backdropPath + "?${TmdbApi.TMDB_API_QUERY}=" + BuildConfig.TMDB_API_KEY
    }
}