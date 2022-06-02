package com.igor.bestmovies.di

import android.content.Context
import com.igor.bestmovies.BuildConfig
import com.igor.bestmovies.data.network.NetworkConnectionInterceptor
import com.igor.bestmovies.data.network.TmdbApi
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    fun provideNetWorkConnectionInterceptor(
        @ApplicationContext context: Context
    ) = NetworkConnectionInterceptor(context)

    @Provides
    fun provideAnalyticsService(
        networkConnectionInterceptor: NetworkConnectionInterceptor
    ): TmdbApi {
        val moshiAdapter = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val okkHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(networkConnectionInterceptor)
            .addInterceptor {
                val original: Request = it.request()
                val originalHttpUrl: HttpUrl = original.url()

                val url = originalHttpUrl.newBuilder()
                    .addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
                    .addQueryParameter("region", "BR")
                    .build()

                val requestBuilder: Request.Builder = original.newBuilder()
                    .url(url)

                val request: Request = requestBuilder.build()
                it.proceed(request)
            }
            .build()

        return Retrofit.Builder()
            .baseUrl(TmdbApi.TMDB_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshiAdapter))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okkHttpClient)
            .build()
            .create(TmdbApi::class.java)
    }
}