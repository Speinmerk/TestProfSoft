package ru.speinmerk.testprofsoft.domain

import ru.speinmerk.testprofsoft.common.utils.Result
import ru.speinmerk.testprofsoft.domain.model.Weather

interface WeatherRepository {
    suspend fun getWeather(city: String): Result<Weather>
}