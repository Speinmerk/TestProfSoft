package ru.speinmerk.testprofsoft.presentation.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.speinmerk.testprofsoft.R
import ru.speinmerk.testprofsoft.common.utils.Result
import ru.speinmerk.testprofsoft.common.validators.EmailValidator
import ru.speinmerk.testprofsoft.common.validators.PasswordValidator
import ru.speinmerk.testprofsoft.domain.RepositoryProvider
import ru.speinmerk.testprofsoft.presentation.view.LoginView

@InjectViewState
class LoginPresenter : MvpPresenter<LoginView>() {
    fun onEmailChanged(text: CharSequence) {
        val isValidEmail = EmailValidator.check(text.toString())
        if (isValidEmail) {
            viewState.showErrorEmail(null)
        }
    }

    fun onPasswordChanged(text: CharSequence) {
        val isValidPassword = PasswordValidator.check(text.toString())
        if (isValidPassword) {
            viewState.showErrorPassword(null)
        }
    }

    fun clickBtnSignIn(email: String, password: String) {
        val isValidEmail = EmailValidator.check(email)
        if (!isValidEmail) {
            val error = EmailValidator.getError(email)
            viewState.showErrorEmail(error?.message)
            return
        }
        val isValidPassword = PasswordValidator.check(password)
        if (!isValidPassword) {
            val error = PasswordValidator.getError(password)
            viewState.showErrorPassword(error?.message)
            return
        }
        viewState.hideKeyboard()
        showWeather()
    }

    fun clickBtnSignUp() {
        // todo Переход на экран регистрации
    }

    fun clickBtnFacebook() {
        // todo Регистрация через Facebook
    }

    fun clickBtnGoogle() {
        // todo Регистрация через Google
    }

    fun clickBtnMail() {
        // todo Регистрация через Mail
    }

    fun clickBtnOK() {
        // todo Регистрация через OK
    }

    fun clickBtnVK() {
        // todo Регистрация через VK
    }

    fun clickBtnForgotPassword() {
        // todo Восстановление пароля
    }

    private fun showWeather() = GlobalScope.launch {
        val weatherRepository = RepositoryProvider.provideWeatherRepository()
        when(val result = weatherRepository.getWeather("Saratov,ru")) {
            is Result.Success -> {
                val weather = result.data
                viewState.showSnackbar(R.string.current_weather, weather.temperature.toString())
            }
            is Result.Error -> {
                viewState.showSnackbar(R.string.request_error)
            }
        }
    }
}