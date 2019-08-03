package ru.speinmerk.testprofsoft.common

import java.math.BigDecimal
import java.math.RoundingMode

object TemperatureConverter {
    fun kelvinToCelsius(temp: Double): Double {
        return BigDecimal(temp - 273.15).setScale(1, RoundingMode.HALF_UP).toDouble()
    }
}