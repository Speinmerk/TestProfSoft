package ru.speinmerk.testprofsoft.repository.mappers

import ru.speinmerk.testprofsoft.common.utils.BaseMapper
import ru.speinmerk.testprofsoft.common.utils.Result
import ru.speinmerk.testprofsoft.common.TemperatureConverter
import ru.speinmerk.testprofsoft.datasource.model.ResponseWeather
import ru.speinmerk.testprofsoft.domain.model.Weather

object WeatherMapper : BaseMapper<Result<ResponseWeather>, Result<Weather>> {
    override fun mapFrom(type: Result<ResponseWeather>): Result<Weather> {
        return when(type) {
            is Result.Success -> Result.Success(map(type.data))
            is Result.Error -> Result.Error(type.exception)
        }
    }

    private fun map(item: ResponseWeather): Weather {
        val temperature = TemperatureConverter.kelvinToCelsius(item.main.temp)
        return Weather(temperature)
    }
}