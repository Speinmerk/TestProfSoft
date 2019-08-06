package ru.speinmerk.testprofsoft.di.module

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.speinmerk.testprofsoft.Const
import ru.speinmerk.testprofsoft.datasource.retrofit.WeatherService
import javax.inject.Singleton

@Module
class ServiceModule {

    @Singleton
    @Provides
    fun provideWeatherService(): WeatherService = Retrofit.Builder()
        .baseUrl(Const.REST_WEATHER)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(WeatherService::class.java)
}