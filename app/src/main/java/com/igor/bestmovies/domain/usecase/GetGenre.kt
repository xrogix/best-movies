package com.igor.bestmovies.domain.usecase

import com.igor.bestmovies.domain.repository.GenreRepository
import javax.inject.Inject

class GetGenre @Inject constructor(
    private val repository: GenreRepository
) {
    suspend operator fun invoke() = repository.fetchGenreAsync()
}