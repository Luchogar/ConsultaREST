package com.example.consultarest.Request

import com.example.consultarest.Response.ExchangeResponse
import retrofit2.Call
import retrofit2.http.GET

interface RequestApi {
    @GET("latest")
    fun getAllPosts(): Call<ExchangeResponse>
}