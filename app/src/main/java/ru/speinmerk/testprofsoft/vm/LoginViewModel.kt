package ru.speinmerk.testprofsoft.vm

import android.app.Application
import android.widget.EditText
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.speinmerk.testprofsoft.R
import ru.speinmerk.testprofsoft.common.SingleLiveEvent
import ru.speinmerk.testprofsoft.common.extensions.context
import ru.speinmerk.testprofsoft.common.utils.Result
import ru.speinmerk.testprofsoft.common.validators.EmailValidator
import ru.speinmerk.testprofsoft.common.validators.PasswordValidator
import ru.speinmerk.testprofsoft.domain.RepositoryProvider

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    var email = ObservableField("1@1.ru")
    var password = ObservableField("123qweA")
    var emailError = ObservableField<String?>()
    var passwordError = ObservableField<String?>()

    val hideKeyboard = SingleLiveEvent<Unit>()
    val showSnackbar = SingleLiveEvent<String>()

    fun onEmailChanged(text: CharSequence) {
        val isValidEmail = EmailValidator.check(text.toString())
        if (isValidEmail) {
            emailError.set(null)
        }
    }

    fun onPasswordChanged(text: CharSequence) {
        val isValidPassword = PasswordValidator.check(text.toString())
        if (isValidPassword) {
            passwordError.set(null)
        }
    }

    fun login(emailEditText: EditText, passwordEditText: EditText) {
        val email = emailEditText.text.toString()
        val isValidEmail = EmailValidator.check(email)
        if (!isValidEmail) {
            val error = EmailValidator.getError(email)
            emailEditText.requestFocus()
            emailError.set(error)
            return
        }
        val password = passwordEditText.text.toString()
        val isValidPassword = PasswordValidator.check(password)
        if (!isValidPassword) {
            val error = PasswordValidator.getError(password)
            passwordEditText.requestFocus()
            passwordError.set(error)
            return
        }
        hideKeyboard.postCall()
        showWeather()
    }

    private fun showWeather() = GlobalScope.launch {
        val weatherRepository = RepositoryProvider.provideWeatherRepository()
        when(val result = weatherRepository.getWeather("Saratov,ru")) {
            is Result.Success -> {
                val weather = result.data
                showSnackbar.postValue(context.getString(R.string.current_weather, weather.temperature.toString()))
            }
            is Result.Error -> {
                showSnackbar.postValue(context.getString(R.string.request_error))
            }
        }
    }
}
