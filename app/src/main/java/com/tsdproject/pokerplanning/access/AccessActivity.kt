package com.tsdproject.pokerplanning.access

import android.os.Bundle
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.base.BaseActivity
import com.tsdproject.pokerplanning.base.BasePresenter
import kotlinx.android.synthetic.main.activity_access.*

class AccessActivity : BaseActivity(), AccessView {

    private lateinit var presenter: AccessPresenter

    override fun providePresenter(): BasePresenter? {
        return presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_access)
        presenter = AccessPresenterImpl(this)
        loginButton.setOnClickListener { onLoginButtonClick() }
    }

    fun onLoginButtonClick() {
        checkCredentialsEditTexts()
    }

    fun checkCredentialsEditTexts() {
        val isLoginEditTextEmpty = loginEditText.text.isEmpty()
        val isPasswordEditTextEmpty = passwordEditText.text.isEmpty()
        if (isLoginEditTextEmpty) {
            loginEditText.error = getString(R.string.blank_edit_text_error)
        } else {
            loginEditText.clearError()
        }
        if (isPasswordEditTextEmpty) {
            passwordEditText.error = getString(R.string.blank_edit_text_error)
        } else {
            passwordEditText.clearError()
        }
    }
}
