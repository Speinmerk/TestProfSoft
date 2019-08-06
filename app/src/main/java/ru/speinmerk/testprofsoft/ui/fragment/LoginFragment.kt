package ru.speinmerk.testprofsoft.ui.fragment

import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.login_fragment.view.*
import ru.speinmerk.testprofsoft.App
import ru.speinmerk.testprofsoft.R
import ru.speinmerk.testprofsoft.presentation.presenter.LoginPresenter
import ru.speinmerk.testprofsoft.presentation.view.LoginView
import ru.speinmerk.testprofsoft.ui.common.BaseTextWatcher
import javax.inject.Inject

class LoginFragment : MvpAppCompatFragment(), LoginView {

    @InjectPresenter(type = PresenterType.GLOBAL)
    lateinit var presenter: LoginPresenter

    @ProvidePresenter(type = PresenterType.GLOBAL)
    fun providePresenter(): LoginPresenter {
        return LoginPresenter()
    }

    lateinit var emailEditTextLayout: TextInputLayout
    lateinit var emailEditText: TextInputEditText
    lateinit var passwordEditTextLayout: TextInputLayout
    lateinit var passwordEditText: TextInputEditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.login_fragment, container, false)
        initEditTexts(view)
        initButtons(view)
        return view
    }

    private fun initEditTexts(view: View) {
        emailEditTextLayout = view.email_layout
        emailEditText = view.email
        passwordEditTextLayout = view.password_layout
        passwordEditText = view.password

        emailEditText.addTextChangedListener(object : BaseTextWatcher {
            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                text?.let { presenter.onEmailChanged(it) }
            }
        })
        passwordEditText.addTextChangedListener(object : BaseTextWatcher {
            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                text?.let { presenter.onPasswordChanged(it) }
            }
        })
    }

    private fun initButtons(view: View) {
        view.btn_facebook.setOnClickListener { presenter.clickBtnFacebook() }
        view.btn_google.setOnClickListener { presenter.clickBtnGoogle() }
        view.btn_mail.setOnClickListener { presenter.clickBtnMail() }
        view.btn_ok.setOnClickListener { presenter.clickBtnOK() }
        view.btn_vk.setOnClickListener { presenter.clickBtnVK() }

        view.btn_sing_in.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            presenter.clickBtnSignIn(email, password)
        }
        view.btn_sing_up.setOnClickListener { presenter.clickBtnSignUp() }
        view.btn_forgot_password.setOnClickListener { presenter.clickBtnForgotPassword() }
    }

    override fun hideKeyboard() {
        val view = activity?.currentFocus ?: return
        val imm = activity?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.hideSoftInputFromWindow(view.windowToken, 0)
    }

    override fun showSnackbar(resStringId: Int, vararg text: String) {
        showSnackbar(getString(resStringId, *text))
    }

    override fun showSnackbar(text: String) {
        Snackbar.make(requireView(), text, Snackbar.LENGTH_LONG).show()
    }

    override fun showErrorEmail(text: String?) {
        emailEditTextLayout.error = text
        text?.run { emailEditText.requestFocus() }
    }

    override fun showErrorPassword(text: String?) {
        passwordEditTextLayout.error = text
        text?.run { passwordEditText.requestFocus() }
    }

}
