package com.tsdproject.pokerplanning.localDatabaseTest

import com.tsdproject.pokerplanning.access.AccessActivity
import com.tsdproject.pokerplanning.database.LocalDatabase
import io.paperdb.Paper
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class LocalDatabaseTest {

    lateinit var accessActivity: AccessActivity
    private var token: String = "12345"
    private var tokenKey: String = "TOKEN"

    @Before
    fun initData() {
        accessActivity = Robolectric.setupActivity(AccessActivity::class.java)
        Paper.init(accessActivity)
    }

    @Test
    fun shouldSaveToken() {
        LocalDatabase.putUserToken(token)
        val tokenFromDatabase: String = Paper.book().read(tokenKey)
        assertEquals(tokenFromDatabase, token)
    }

    @Test
    fun shouldGetToken() {
        Paper.book().write(tokenKey, token)
        val tokenFromDatabase = LocalDatabase.getUserToken()
        assertEquals(tokenFromDatabase, token)
    }

}