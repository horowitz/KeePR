package com.dhorowitz.keepr.core.network

import com.dhorowitz.keepr.core.network.model.PRDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {
    @GET("/repos/{org}/{repo}/pulls")
    suspend fun getPRs(@Path("org") org: String,
                       @Path("repo") repo: String): Response<List<PRDto>>

    companion object {
        const val BASE_URL = "https://api.github.com"
    }
}
