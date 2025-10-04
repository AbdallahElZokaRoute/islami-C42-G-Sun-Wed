package com.route.islamic42gsunwed.fragments.radio.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiManager {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://mp3quran.net/api/v3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun getRadioService(): RadioService {
        return retrofit.create(RadioService::class.java)
    }
}
