package com.tsdproject.pokerplanning.accessTest

import android.widget.TextView
import com.rey.material.widget.EditText
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.access.AccessActivity
import junit.framework.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class AccessActivityTest {

    lateinit var accessActivity: AccessActivity

    @Before
    fun initData() {
        accessActivity = Robolectric.setupActivity(AccessActivity::class.java)
    }

    @Test
    fun shouldNotBeNull() {
        assertNotNull(accessActivity)
    }

    @Test
    fun shouldEditTextsBeEmpty() {
        val loginEditText = accessActivity.findViewById<EditText>(R.id.loginEditText)
        val passwordEditText = accessActivity.findViewById<EditText>(R.id.passwordEditText)
        assertTrue(loginEditText.text.isEmpty())
        assertTrue(passwordEditText.text.isEmpty())
    }

    @Test
    fun shouldLoginEditTextErrorBeEmpty() {
        val loginEditText = accessActivity.findViewById<EditText>(R.id.loginEditText)
        assertNull(loginEditText.error)
    }

    @Test
    fun shouldPasswordEditTextErrorBeEmpty() {
        val passwordEditText = accessActivity.findViewById<EditText>(R.id.passwordEditText)
        assertNull(passwordEditText.error)
    }

    @Test
    fun shouldLoginEditTextShowEmptyError() {
        val loginEditText = accessActivity.findViewById<EditText>(R.id.loginEditText)
        val loginButton = accessActivity.findViewById<TextView>(R.id.loginButton)
        loginButton.performClick()
        assertEquals(loginEditText.error, accessActivity.resources.getString(R.string.blank_edit_text_error))
    }

    @Test
    fun shouldPasswordEditTextShowEmptyError() {
        val passwordEditText = accessActivity.findViewById<EditText>(R.id.passwordEditText)
        val loginButton = accessActivity.findViewById<TextView>(R.id.loginButton)
        loginButton.performClick()
        assertEquals(passwordEditText.error, accessActivity.resources.getString(R.string.blank_edit_text_error))
    }
}