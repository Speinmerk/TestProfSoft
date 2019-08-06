package ru.speinmerk.testprofsoft.repository

import ru.speinmerk.testprofsoft.common.utils.Result
import ru.speinmerk.testprofsoft.datasource.WeatherDataSource
import ru.speinmerk.testprofsoft.domain.WeatherRepository
import ru.speinmerk.testprofsoft.domain.model.Weather
import ru.speinmerk.testprofsoft.repository.mappers.WeatherMapper
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val weatherDataSource: WeatherDataSource) : WeatherRepository {
    override suspend fun getWeather(city: String): Result<Weather> {
        val result = weatherDataSource.getCurrentWeather(city)
        return WeatherMapper.mapFrom(result)
    }
}