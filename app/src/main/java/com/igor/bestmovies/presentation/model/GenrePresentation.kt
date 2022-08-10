package com.igor.bestmovies.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GenrePresentation(
    val id: Int?,
    val name: String?
): Parcelable