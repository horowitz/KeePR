package com.dhorowitz.keepr.di

import com.dhorowitz.keepr.core.network.GithubApi
import com.dhorowitz.keepr.core.network.GithubRepository
import com.dhorowitz.keepr.core.network.GithubRepository.NetworkDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    @Provides
    fun remoteDataSourceProvider(api: GithubApi): GithubRepository = NetworkDataSource(api)
}
