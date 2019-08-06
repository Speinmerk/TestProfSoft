package ru.speinmerk.testprofsoft.di

import dagger.Component
import ru.speinmerk.testprofsoft.di.module.RepositoryModule
import ru.speinmerk.testprofsoft.di.module.ServiceModule
import ru.speinmerk.testprofsoft.presentation.presenter.LoginPresenter
import ru.speinmerk.testprofsoft.ui.fragment.LoginFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [ServiceModule::class, RepositoryModule::class
])
interface AppComponent {
    fun inject(fragment: LoginFragment)
    fun inject(presenter: LoginPresenter)
}