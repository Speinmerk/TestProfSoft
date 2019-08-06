package ru.speinmerk.testprofsoft

import android.app.Application
import ru.speinmerk.testprofsoft.di.AppComponent
import ru.speinmerk.testprofsoft.di.DaggerAppComponent

class App : Application() {
    companion object {
        lateinit var component: AppComponent private set
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().build()
    }
}