package com.tsdproject.pokerplanning.manageRoomsTest

import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.manageroom.ManageRoomsActivity
import junit.framework.Assert
import kotlinx.android.synthetic.main.activity_manage_rooms.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class ManageRoomsActivityTest {

    lateinit var manageRoomsActivity: ManageRoomsActivity

    @Before
    fun initData() {
        manageRoomsActivity = Robolectric.setupActivity(ManageRoomsActivity::class.java)
    }

    @Test
    fun shouldNotBeNull() {
        Assert.assertNotNull(manageRoomsActivity)
    }

    @Test
    fun shouldEditTextsBeEmpty() {
        val tableIdEditText = manageRoomsActivity.tableIdEditText
        Assert.assertTrue(tableIdEditText.text.isEmpty())
    }

    @Test
    fun shouldTableIdEditTextErrorBeEmpty() {
        val tableIdEditText = manageRoomsActivity.tableIdEditText
        Assert.assertNull(tableIdEditText.error)
    }

    @Test
    fun shouldTableIdEditTextShowEmptyError() {
        val tableIdEditText = manageRoomsActivity.tableIdEditText
        val joinRoomButton = manageRoomsActivity.joinRoomButton
        joinRoomButton.performClick()
        Assert.assertEquals(
            tableIdEditText.error,
            manageRoomsActivity.resources.getString(R.string.blank_edit_text_error)
        )
    }
}