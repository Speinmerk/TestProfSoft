package ru.speinmerk.testprofsoft.repository

import io.reactivex.Observable
import ru.speinmerk.testprofsoft.datasource.WeatherDataSource
import ru.speinmerk.testprofsoft.domain.WeatherRepository
import ru.speinmerk.testprofsoft.domain.model.Weather
import ru.speinmerk.testprofsoft.repository.mappers.WeatherMapper
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val weatherDataSource: WeatherDataSource) : WeatherRepository {
    override fun getWeather(city: String): Observable<Weather> {
        return weatherDataSource.getCurrentWeather(city)
            .map(WeatherMapper)
    }
}