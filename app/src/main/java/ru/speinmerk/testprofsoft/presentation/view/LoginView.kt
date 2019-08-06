package ru.speinmerk.testprofsoft.presentation.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface LoginView : MvpView {

    @StateStrategyType(SkipStrategy::class)
    fun hideKeyboard()

    @StateStrategyType(SkipStrategy::class)
    fun showSnackbar(resStringId: Int, vararg text: String)

    @StateStrategyType(SkipStrategy::class)
    fun showSnackbar(text: String)

    fun showErrorEmail(text: String?)

    fun showErrorPassword(text: String?)
}