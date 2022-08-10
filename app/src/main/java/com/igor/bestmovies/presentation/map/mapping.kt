package com.igor.bestmovies.presentation.map

import com.igor.bestmovies.domain.model.Show
import com.igor.bestmovies.presentation.model.GenrePresentation
import com.igor.bestmovies.presentation.model.ShowPresentation

fun Show.toMapPresentation(): ShowPresentation {
    return ShowPresentation(
        genres?.map {
           GenrePresentation(it.id, it.name)
        },
        originalName,
        genreIds,
        name,
        voteCount,
        backdropPath,
        originalLanguage,
        id,
        overview,
        posterPath
    )
}

fun List<Show>.toMapPresentation(): List<ShowPresentation> {
    return this.map { show ->
        show.toMapPresentation()
    }
}