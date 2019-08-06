package ru.speinmerk.testprofsoft.presentation.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface LoginView : MvpView {
    fun hideKeyboard()
    fun showSnackbar(resStringId: Int, vararg text: String)
    fun showSnackbar(text: String)
    fun showErrorEmail(text: String?)
    fun showErrorPassword(text: String?)
}