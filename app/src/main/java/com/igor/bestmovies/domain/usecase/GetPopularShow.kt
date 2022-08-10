package com.igor.bestmovies.domain.usecase

import com.igor.bestmovies.domain.repository.PopularShowRepository
import com.igor.bestmovies.domain.model.Genre
import javax.inject.Inject

class GetPopularShow @Inject constructor(
    private val repository: PopularShowRepository
) {
    suspend operator fun invoke(
        genres: List<Genre>
    ) = repository.fetchPopularShowsAsync()
        ?.results
        ?.map { show ->
            show.copy(genres = genres.filter { genre ->
                show.genreIds?.contains(genre.id) == true
            })
        }
        ?: emptyList()
}