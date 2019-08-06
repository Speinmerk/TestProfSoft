package ru.speinmerk.testprofsoft.datasource

import io.reactivex.Observable
import ru.speinmerk.testprofsoft.datasource.model.ResponseWeather
import ru.speinmerk.testprofsoft.datasource.retrofit.WeatherService
import javax.inject.Inject

class WeatherDataSource @Inject constructor(private val service: WeatherService) {

    fun getCurrentWeather(city: String): Observable<ResponseWeather> {
        return service.getCurrentWeather(city)
    }
}