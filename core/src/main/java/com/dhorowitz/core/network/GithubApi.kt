package com.dhorowitz.core.network

import androidx.annotation.WorkerThread
import com.dhorowitz.core.network.model.PRDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {
    @WorkerThread
    @GET("/repos/{org}/{repo}/pulls")
    suspend fun getPRs(@Path("org") org: String,
                       @Path("repo") repo: String): Response<List<PRDto>>

    companion object {
        const val BASE_URL = "https://api.github.com"
    }
}