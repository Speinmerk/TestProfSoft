package ru.speinmerk.testprofsoft.vm

import android.widget.EditText
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import ru.speinmerk.testprofsoft.common.SingleLiveEvent
import ru.speinmerk.testprofsoft.common.validators.EmailValidator
import ru.speinmerk.testprofsoft.common.validators.PasswordValidator

class LoginViewModel : ViewModel() {
    var emailError = ObservableField<String?>()
    var passwordError = ObservableField<String?>()

    val hideKeyboard = SingleLiveEvent<Unit>()

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
    }
}
