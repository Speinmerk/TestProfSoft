package ru.speinmerk.testprofsoft.datasource

import ru.speinmerk.testprofsoft.datasource.model.ResponseWeather
import ru.speinmerk.testprofsoft.common.utils.Result
import ru.speinmerk.testprofsoft.datasource.retrofit.WeatherService
import java.lang.Exception
import javax.inject.Inject

class WeatherDataSource @Inject constructor(private val service: WeatherService) {

    suspend fun getCurrentWeather(city: String): Result<ResponseWeather> {
        return try {
            val response = service.getCurrentWeather(city)
            Result.Success(response)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}