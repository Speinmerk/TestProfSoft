package ru.speinmerk.testprofsoft.presentation.view

import com.arellomobile.mvp.MvpView

interface LoginView : MvpView {
    fun hideKeyboard()
    fun showSnackbar(resStringId: Int, vararg text: String)
    fun showSnackbar(text: String)
    fun showErrorEmail(text: String?)
    fun showErrorPassword(text: String?)
}