package com.example.myweatherapi

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("weather")
    fun getWeather(@Query("q") city: String,
                   @Query("appid") key: String,
                   @Query("units") units: String): Observable<Weather>
}