package ru.speinmerk.testprofsoft.domain

import ru.speinmerk.testprofsoft.datasource.WeatherDataSource
import ru.speinmerk.testprofsoft.repository.WeatherRepositoryImpl

object RepositoryProvider {
    fun provideWeatherRepository(): WeatherRepository = WeatherRepositoryImpl(WeatherDataSource())
}