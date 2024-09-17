package com.example.krishibazaar.Presentation.weather.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("/v1/current.json")
    suspend fun getWeather(
        @Query("Key") apikey: String,
        @Query("q") city: String
    ): Response<WeatherModel>
}