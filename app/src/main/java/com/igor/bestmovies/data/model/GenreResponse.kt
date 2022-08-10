package com.igor.bestmovies.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GenreResponse(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "name")
    val name: String?
): Parcelable