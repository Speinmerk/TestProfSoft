package ru.speinmerk.testprofsoft.repository.mappers

import io.reactivex.functions.Function
import ru.speinmerk.testprofsoft.common.TemperatureConverter
import ru.speinmerk.testprofsoft.datasource.model.ResponseWeather
import ru.speinmerk.testprofsoft.domain.model.Weather

object WeatherMapper : Function<ResponseWeather, Weather> {
    override fun apply(response: ResponseWeather): Weather {
        val temperature = TemperatureConverter.kelvinToCelsius(response.main.temp)
        return Weather(temperature)
    }
}