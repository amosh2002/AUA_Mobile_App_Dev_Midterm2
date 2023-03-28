package com.example.midterm2.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface UsersApiService {
    @GET(API)
    suspend fun fetchUsers(
        @Query("inc") fields: String,
        @Query("results") results: Int
    ): Response<FullResponse>
}
