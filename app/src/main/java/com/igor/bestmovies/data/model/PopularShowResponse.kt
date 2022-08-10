package com.igor.bestmovies.data.model

import com.squareup.moshi.Json

data class PopularShowResponse(
    @Json(name = "page")
    val page: Int?,

    @Json(name = "total_results")
    val totalResults: Int?,

    @Json(name = "total_pages")
    val totalPages: Int?,

    @Json(name = "results")
    val results: List<ShowResponse>?
)