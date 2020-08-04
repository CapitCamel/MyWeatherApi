package com.example.myweatherapi

import com.google.gson.annotations.SerializedName

data class WeatherMain(
    val temp: Float = 0f,
    val pressure: Float = 0f,
    val humidity: Float = 0f,

    @SerializedName("temp_min") val minTemp: Float = 0f,
    @SerializedName("temp_max") val maxTemp: Float = 0f
)