package com.igor.bestmovies.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ShowPresentation(
    val genres: List<GenrePresentation>?,
    val originalName: String?,
    val genreIds: List<Int>?,
    val name: String?,
    val voteCount: Int?,
    val backdropPath: String?,
    val originalLanguage: String?,
    val id: Int?,
    val overview: String?,
    val posterPath: String?
): Parcelable