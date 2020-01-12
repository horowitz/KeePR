package com.dhorowitz.core.network.di

import com.dhorowitz.core.network.GithubApi
import com.dhorowitz.core.network.GithubRepository
import com.dhorowitz.core.network.GithubRepository.Network
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.instance
import org.kodein.di.erased.provider
import org.kodein.di.erased.singleton
import retrofit2.Retrofit.Builder
import retrofit2.converter.moshi.MoshiConverterFactory.create


val restInfrastructureModule = Kodein.Module("network") {

    bind() from singleton {

        val logger = HttpLoggingInterceptor().apply {
            level = BODY
        }

        val okHttp = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        val retrofit = with(Builder()) {
            baseUrl(GithubApi.BASE_URL)
            client(okHttp)
            addConverterFactory(create())
            build()
        }

        retrofit.create(GithubApi::class.java)
    }

    bind<GithubRepository>() with provider {
        Network(instance())
    }
}