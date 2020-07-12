package com.dhorowitz.keepr.core.network.di

import com.dhorowitz.keepr.BuildConfig.KEEPR_CLIENT_ID
import com.dhorowitz.keepr.BuildConfig.KEEPR_CLIENT_SECRET
import com.dhorowitz.keepr.core.network.AuthenticationInterceptor
import com.dhorowitz.keepr.core.network.GithubApi
import com.dhorowitz.keepr.core.network.GithubApi.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {
    private val credentials = Credentials.basic(KEEPR_CLIENT_ID, KEEPR_CLIENT_SECRET)

    private val okHttpClient =
        OkHttpClient()
            .newBuilder()
            .addInterceptor(HttpLoggingInterceptor())
            .addInterceptor(AuthenticationInterceptor(credentials))
            .build()

    @Provides
    fun provideGithubApi(): GithubApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(GithubApi::class.java)
}
