package com.route.islamic42gsunwed.fragments.radio.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RadioService {
    @GET("radios")
    suspend fun getRadios(
        @Query("page") page: Int,
        @Query("size") size: Int
    ):Response<RadioResponse>
}