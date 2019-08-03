package ru.speinmerk.testprofsoft.datasource.retrofit

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import ru.speinmerk.testprofsoft.datasource.RetrofitFactory
import ru.speinmerk.testprofsoft.datasource.model.ResponseWeather

interface WeatherService {
    @GET("/weather")
    @Headers(value = ["X-RapidAPI-Key: ${RetrofitFactory.API_KEY}"])
    suspend fun getCurrentWeather(@Query("q") city: String): ResponseWeather
}