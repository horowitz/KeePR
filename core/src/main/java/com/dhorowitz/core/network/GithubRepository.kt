package com.dhorowitz.core.network

import com.dhorowitz.core.network.model.PRDto

interface GithubRepository {
    suspend fun getPRs(): List<PRDto>

    class Network(private val githubApi: GithubApi) : GithubRepository {

        override suspend fun getPRs(): List<PRDto> {
            return githubApi.getPRs("", "").body()!!
        }

    }
}