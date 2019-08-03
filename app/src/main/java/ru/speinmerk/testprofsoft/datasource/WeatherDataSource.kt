package ru.speinmerk.testprofsoft.datasource

import ru.speinmerk.testprofsoft.datasource.model.ResponseWeather
import ru.speinmerk.testprofsoft.common.utils.Result
import java.lang.Exception

class WeatherDataSource {
    private val service = RetrofitFactory.makeWeatherService()

    suspend fun getCurrentWeather(city: String): Result<ResponseWeather> {
        return try {
            val response = service.getCurrentWeather(city)
            Result.Success(response)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}