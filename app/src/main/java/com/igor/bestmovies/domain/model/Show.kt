package com.igor.bestmovies.domain.model

data class Show(
    val genres: List<Genre>?,
    val originalName: String?,
    val genreIds: List<Int>?,
    val name: String?,
    val voteCount: Int?,
    val backdropPath: String?,
    val originalLanguage: String?,
    val id: Int?,
    val overview: String?,
    val posterPath: String?
)