package ru.speinmerk.testprofsoft.repository

interface WeatherRepository {
    suspend fun getWeather()
}