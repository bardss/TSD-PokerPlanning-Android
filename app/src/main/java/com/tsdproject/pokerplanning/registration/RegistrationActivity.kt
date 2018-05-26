package com.tsdproject.pokerplanning.registration

import android.os.Bundle
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.base.BaseActivity
import com.tsdproject.pokerplanning.base.BasePresenter
import com.tsdproject.pokerplanning.model.utils.EditTextUtil
import kotlinx.android.synthetic.main.activity_registration.*


class RegistrationActivity : BaseActivity(), RegistrationView {

    private lateinit var presenter: RegistrationPresenter

    override fun providePresenter(): BasePresenter? {
        return presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        presenter = RegistrationPresenterImpl(this)
        registerButton.setOnClickListener { onRegisterButtonClick() }
    }

    private fun onRegisterButtonClick() {
        EditTextUtil.checkIfEditTextEmpty(loginEditText)
        EditTextUtil.checkIfEditTextEmpty(passwordEditText)
        EditTextUtil.checkIfEditTextEmpty(confirmPasswordEditText)
    }
}