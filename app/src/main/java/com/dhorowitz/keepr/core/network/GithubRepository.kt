package com.dhorowitz.keepr.core.network

import com.dhorowitz.keepr.core.network.model.PRDto

interface GithubRepository {
    suspend fun getPRs(): List<PRDto>

    class NetworkDataSource(private val githubApi: GithubApi) : GithubRepository {
        override suspend fun getPRs(): List<PRDto> = githubApi.getPRs("", "").body()!!
    }
}
