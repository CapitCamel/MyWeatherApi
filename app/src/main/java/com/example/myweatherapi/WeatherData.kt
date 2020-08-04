package com.example.myweatherapi

import com.google.gson.annotations.SerializedName

data class Weather(
    val main: WeatherMain,

    @SerializedName("icon") val icon: String

)