package com.igor.bestmovies.domain.model

data class PopularShow(
    val page: Int?,
    val totalResults: Int?,
    val totalPages: Int?,
    val results: List<Show>?
)
