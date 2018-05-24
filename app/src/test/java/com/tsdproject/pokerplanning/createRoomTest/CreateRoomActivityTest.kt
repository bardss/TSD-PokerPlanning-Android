package com.tsdproject.pokerplanning.createRoomTest

import android.widget.TextView
import com.rey.material.widget.EditText
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.createroom.CreateRoomActivity
import junit.framework.Assert
import kotlinx.android.synthetic.main.activity_create_room.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class CreateRoomActivityTest {

    lateinit var createRoomActivity: CreateRoomActivity

    @Before
    fun initData() {
        createRoomActivity = Robolectric.setupActivity(CreateRoomActivity::class.java)
    }

    @Test
    fun shouldNotBeNull() {
        Assert.assertNotNull(createRoomActivity)
    }

    @Test
    fun shouldEditTextsBeEmpty() {
        val tableIdEditText = createRoomActivity.tableIdEditText
        val tableNameEditText = createRoomActivity.tableNameEditText
        Assert.assertTrue(tableNameEditText.text.isEmpty())
        Assert.assertTrue(tableIdEditText.text.isEmpty())
    }

    @Test
    fun shouldTableNameEditTextErrorBeEmpty() {
        val tableNameEditText = createRoomActivity.tableNameEditText
        Assert.assertNull(tableNameEditText.error)
    }

    @Test
    fun shouldTableIdEditTextErrorBeEmpty() {
        val tableIdEditText = createRoomActivity.tableIdEditText
        Assert.assertNull(tableIdEditText.error)
    }

    @Test
    fun shouldTableNameEditTextShowEmptyError() {
        val tableNameEditText = createRoomActivity.tableNameEditText
        val createRoomButton = createRoomActivity.createRoomButton
        createRoomButton.performClick()
        Assert.assertEquals(
            tableNameEditText.error,
            createRoomActivity.resources.getString(R.string.blank_edit_text_error)
        )
    }

    @Test
    fun shouldTableIdEditTextShowEmptyError() {
        val tableIdEditText = createRoomActivity.tableIdEditText
        val joinRoomButton = createRoomActivity.joinRoomButton
        joinRoomButton.performClick()
        Assert.assertEquals(
            tableIdEditText.error,
            createRoomActivity.resources.getString(R.string.blank_edit_text_error)
        )
    }
}