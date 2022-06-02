package com.igor.bestmovies.di

import com.igor.bestmovies.data.datasource.Datasource
import com.igor.bestmovies.data.datasource.RemoteDatasource
import com.igor.bestmovies.data.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModules {

    @Singleton
    @Binds
    abstract fun bindGenreRepository(
        genreRepositoryImpl: GenreRepositoryImpl
    ): GenreRepository

    @Singleton
    @Binds
    abstract fun bindPopularShowRepository(
        popularShowRepositoryImpl: PopularShowRepositoryImpl
    ): PopularShowRepository

    @Singleton
    @Binds
    abstract fun bindShowDetailRepository(
        detailShowRepositoryImpl: ShowDetailRepositoryImpl
    ): ShowDetailRepository

    @Singleton
    @Binds
    abstract fun bindDatasource(
        remoteDatasource: RemoteDatasource
    ): Datasource
}