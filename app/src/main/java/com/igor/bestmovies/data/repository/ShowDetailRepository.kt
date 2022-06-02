package com.igor.bestmovies.data.repository

import com.igor.bestmovies.domain.model.Show

interface ShowDetailRepository {
    suspend fun fetchAsync(id: Int) : Show?
}