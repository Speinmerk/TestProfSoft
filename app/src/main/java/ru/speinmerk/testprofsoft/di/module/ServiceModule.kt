package ru.speinmerk.testprofsoft.di.module

import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
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
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(WeatherService::class.java)
}