package com.tsdproject.pokerplanning.registration

import android.content.Intent
import android.os.Bundle
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.access.AccessActivity
import com.tsdproject.pokerplanning.base.BaseActivity
import com.tsdproject.pokerplanning.base.BasePresenter
import com.tsdproject.pokerplanning.model.transportobjects.AddUserTO
import com.tsdproject.pokerplanning.model.utils.EditTextUtil
import com.tsdproject.pokerplanning.model.utils.ResUtil
import com.tsdproject.pokerplanning.model.utils.ToastUtil
import com.tsdproject.pokerplanning.model.utils.ValidationUtil
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : BaseActivity(), RegistrationView {

    override fun showSuccessToast() {
        ToastUtil.show(this, ResUtil.getString(R.string.account_created), 1000)
    }

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
        if (checkIfEditTextsEmpty() &&
            checkIfCorrectEmail() &&
            checkIfSamePasswords()) {
            presenter.registerUser(createAddUser())
        }
    }

    private fun checkIfCorrectEmail(): Boolean {
        return if (ValidationUtil.checkIfValid(loginEditText.text.toString(), ValidationUtil.Regex.EMAIL)) {
            loginEditText.clearError()
            true
        } else {
            loginEditText.error = ResUtil.getString(R.string.email_is_not_correct)
            false
        }
    }

    private fun createAddUser(): AddUserTO {
        return AddUserTO(
            firstNameEditText.text.toString(),
            lastNameEditText.text.toString(),
            loginEditText.text.toString(),
            passwordEditText.text.toString()
        )
    }

    private fun checkIfSamePasswords(): Boolean {
        val password = passwordEditText.text.toString()
        val confirmPassword = confirmPasswordEditText.text.toString()
        return if (password == confirmPassword && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
            passwordEditText.clearError()
            confirmPasswordEditText.clearError()
            true
        } else {
            passwordEditText.error = ResUtil.getString(R.string.passwords_are_not_the_same)
            confirmPasswordEditText.error = ResUtil.getString(R.string.passwords_are_not_the_same)
            false
        }
    }

    private fun checkIfEditTextsEmpty(): Boolean {
        val firstNameIsNotEmpty = !EditTextUtil.checkIfEditTextEmpty(firstNameEditText)
        val lastNameIsNotEmpty = !EditTextUtil.checkIfEditTextEmpty(lastNameEditText)
        val loginNameIsNotEmpty = !EditTextUtil.checkIfEditTextEmpty(loginEditText)
        val passwordNameIsNotEmpty = !EditTextUtil.checkIfEditTextEmpty(passwordEditText)
        val confirmPassowrdNameIsNotEmpty = !EditTextUtil.checkIfEditTextEmpty(confirmPasswordEditText)
        return firstNameIsNotEmpty &&
                lastNameIsNotEmpty &&
                loginNameIsNotEmpty &&
                passwordNameIsNotEmpty &&
                confirmPassowrdNameIsNotEmpty
    }

    override fun navigateToAccess() {
        startActivity(Intent(this, AccessActivity::class.java))
    }
}