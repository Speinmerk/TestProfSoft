package ru.speinmerk.testprofsoft.di.module

import dagger.Module
import dagger.Provides
import ru.speinmerk.testprofsoft.datasource.WeatherDataSource
import ru.speinmerk.testprofsoft.domain.WeatherRepository
import ru.speinmerk.testprofsoft.repository.WeatherRepositoryImpl
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideWeatherRepository(weatherDataSource: WeatherDataSource): WeatherRepository {
        return WeatherRepositoryImpl(weatherDataSource)
    }
}