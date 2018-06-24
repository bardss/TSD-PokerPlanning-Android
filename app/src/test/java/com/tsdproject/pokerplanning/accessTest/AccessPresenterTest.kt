package com.tsdproject.pokerplanning.accessTest

import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.access.AccessActivity
import com.tsdproject.pokerplanning.access.AccessPresenter
import com.tsdproject.pokerplanning.access.AccessPresenterImpl
import com.tsdproject.pokerplanning.model.utils.ResUtil
import com.tsdproject.pokerplanning.service.receivers.LoginReceiver
import junit.framework.Assert.*
import kotlinx.android.synthetic.main.activity_access.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class AccessPresenterTest {

    lateinit var accessActivity: AccessActivity
    lateinit var accessPresenter: AccessPresenter

    @Before
    fun initData() {
        accessActivity = Robolectric.setupActivity(AccessActivity::class.java)
        accessPresenter = AccessPresenterImpl(accessActivity)
    }

    @Test
    fun shouldNotBeNull() {
        assertNotNull(accessPresenter)
    }

    @Test
    fun shouldCleanEditTextValueOnLoginSuccess() {
        val loginEditText = accessActivity.loginEditText
        val passwordEditText = accessActivity.passwordEditText
        (accessPresenter as LoginReceiver).onLoginSuccess("")
        assertTrue(loginEditText.text.isEmpty())
        assertTrue(passwordEditText.text.isEmpty())
    }

    @Test
    fun shouldCleanEditTextErrorOnLoginSuccess() {
        val loginEditText = accessActivity.loginEditText
        val passwordEditText = accessActivity.passwordEditText
        loginEditText.error = ResUtil.getString(R.string.wrong_login_password)
        passwordEditText.error = ResUtil.getString(R.string.wrong_login_password)
        (accessPresenter as LoginReceiver).onLoginSuccess("")
        assertNull(loginEditText.error)
        assertNull(passwordEditText.error)
    }

    @Test
    fun shouldCleanEditTextErrorOnLoginError() {
        val loginEditText = accessActivity.loginEditText
        val passwordEditText = accessActivity.passwordEditText
        (accessPresenter as LoginReceiver).onLoginError(ResUtil.getString(R.string.wrong_login_password))
        assertEquals(loginEditText.error, ResUtil.getString(R.string.wrong_login_password))
        assertEquals(passwordEditText.error, ResUtil.getString(R.string.wrong_login_password))
    }
    

}