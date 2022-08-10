package com.igor.bestmovies.domain.usecase

import com.igor.bestmovies.domain.repository.ShowDetailRepository
import javax.inject.Inject

class GetShowDetail @Inject constructor(
    private val repository : ShowDetailRepository
) {
    suspend operator fun invoke(id : Int) = repository.fetchAsync(id)
}