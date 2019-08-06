package ru.speinmerk.testprofsoft.presentation.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import ru.speinmerk.testprofsoft.App
import ru.speinmerk.testprofsoft.R
import ru.speinmerk.testprofsoft.common.validators.EmailValidator
import ru.speinmerk.testprofsoft.common.validators.PasswordValidator
import ru.speinmerk.testprofsoft.domain.WeatherRepository
import ru.speinmerk.testprofsoft.presentation.view.LoginView
import javax.inject.Inject

@InjectViewState
class LoginPresenter : MvpPresenter<LoginView>() {

    @Inject
    lateinit var weatherRepository: WeatherRepository

    init {
        App.component.inject(this)
    }

    private var disposable: Disposable? = null

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

    private fun showWeather() {
        if (disposable?.isDisposed != false) {
            disposable?.dispose()
        }
        disposable = weatherRepository.getWeather("Saratov,ru")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showSnackbar(R.string.current_weather, it.temperature.toString())
            }, {
                viewState.showSnackbar(R.string.request_error)
            })
    }
}