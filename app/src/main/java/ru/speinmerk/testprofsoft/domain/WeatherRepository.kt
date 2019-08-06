package ru.speinmerk.testprofsoft.domain

import io.reactivex.Observable
import ru.speinmerk.testprofsoft.domain.model.Weather

interface WeatherRepository {
    fun getWeather(city: String): Observable<Weather>
}