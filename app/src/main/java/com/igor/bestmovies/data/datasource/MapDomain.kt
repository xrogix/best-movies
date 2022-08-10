package com.igor.bestmovies.data.datasource

import com.igor.bestmovies.data.model.GenreListResponse
import com.igor.bestmovies.data.model.PopularShowResponse
import com.igor.bestmovies.data.model.ShowResponse
import com.igor.bestmovies.domain.model.Show
import com.igor.bestmovies.domain.model.Genre
import com.igor.bestmovies.domain.model.PopularShow

fun GenreListResponse.toMapDomain(): List<Genre> {
    return this.genres?.map {
        Genre(
            it.id,
            it.name,
        )
    } ?: emptyList()
}

fun PopularShowResponse.toMapDomain(): PopularShow {
    return PopularShow(
        page,
        totalResults,
        totalPages,
        results?.toMapDomain()
    )
}

fun List<ShowResponse>.toMapDomain(): List<Show> {
    return this.map { showResponse ->
        showResponse.toMapDomain()
    }
}

fun ShowResponse.toMapDomain(): Show {
    return Show(
        genres?.map { genre ->
            Genre(genre.id, genre.name)
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