package com.tsdproject.pokerplanning.registration

import com.tsdproject.pokerplanning.R
import junit.framework.Assert
import kotlinx.android.synthetic.main.activity_registration.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class RegistrationActivityTest {

    lateinit var registrationActivity: RegistrationActivity

    @Before
    fun initData() {
        registrationActivity = Robolectric.setupActivity(RegistrationActivity::class.java)
    }

    @Test
    fun shouldNotBeNull() {
        Assert.assertNotNull(registrationActivity)
    }

    @Test
    fun shouldEditTextsBeEmpty() {
        val loginEditText = registrationActivity.loginEditText
        val passwordEditText = registrationActivity.passwordEditText
        val confirmPasswordEditText = registrationActivity.confirmPasswordEditText
        Assert.assertTrue(loginEditText.text.isEmpty())
        Assert.assertTrue(passwordEditText.text.isEmpty())
        Assert.assertTrue(confirmPasswordEditText.text.isEmpty())
    }

    @Test
    fun shouldLoginEditTextErrorBeEmpty() {
        val loginEditText = registrationActivity.loginEditText
        Assert.assertNull(loginEditText.error)
    }

    @Test
    fun shouldConfirmPasswordEditTextErrorBeEmpty() {
        val passwordEditText = registrationActivity.passwordEditText
        Assert.assertNull(passwordEditText.error)
    }

    @Test
    fun shouldPasswordEditTextErrorBeEmpty() {
        val confirmPasswordEditText = registrationActivity.confirmPasswordEditText
        Assert.assertNull(confirmPasswordEditText.error)
    }

    @Test
    fun shouldLoginEditTextShowEmptyError() {
        val loginEditText = registrationActivity.loginEditText
        val registerButton = registrationActivity.registerButton
        registerButton.performClick()
        Assert.assertEquals(
            loginEditText.error,
            registrationActivity.resources.getString(R.string.blank_edit_text_error)
        )
    }
    @Test
    fun shouldPasswordEditTextShowEmptyError() {
        val passwordEditText = registrationActivity.passwordEditText
        val registerButton= registrationActivity.registerButton
        registerButton.performClick()
        Assert.assertEquals(
            passwordEditText.error,
            registrationActivity.resources.getString(R.string.blank_edit_text_error)
        )
    }

    @Test
    fun shouldConfirmPasswordEditTextShowEmptyError() {
        val confirmPasswordEditText = registrationActivity.confirmPasswordEditText
        val registerButton= registrationActivity.registerButton
        registerButton.performClick()
        Assert.assertEquals(
            confirmPasswordEditText .error,
            registrationActivity.resources.getString(R.string.blank_edit_text_error)
        )
    }
}