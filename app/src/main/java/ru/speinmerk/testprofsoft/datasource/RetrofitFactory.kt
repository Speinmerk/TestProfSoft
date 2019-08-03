package ru.speinmerk.testprofsoft.datasource

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.speinmerk.testprofsoft.datasource.retrofit.WeatherService

object RetrofitFactory {
    private const val REST_WEATHER = "https://community-open-weather-map.p.rapidapi.com"
    const val API_KEY = "8b02d2a796msh88eda74d09fbd32p10fcb1jsn1bcca32b507b"

    fun makeWeatherService(): WeatherService = Retrofit.Builder()
        .baseUrl(REST_WEATHER)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(WeatherService::class.java)
}