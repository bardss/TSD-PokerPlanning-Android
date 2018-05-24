package com.tsdproject.pokerplanning.participants

import android.graphics.Typeface
import android.support.v7.widget.LinearLayoutManager
import android.widget.TextView
import com.tsdproject.pokerplanning.R
import junit.framework.Assert.*
import kotlinx.android.synthetic.main.activity_participants.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ParticipantsActivityTest {

    lateinit var participantsActivity: ParticipantsActivity

    @Before
    fun initData() {
        participantsActivity = Robolectric.setupActivity(ParticipantsActivity::class.java)
    }

    @Test
    fun shouldNotBeNull() {
        assertNotNull(participantsActivity)
    }

    @Test
    fun recyclerViewShouldNotBeNull() {
        val participantsRecyclerView = participantsActivity.participantsRecyclerView
        assertNotNull(participantsRecyclerView.adapter)
    }

    @Test
    fun recyclerViewShouldHaveLinearLayoutManager() {
        val participantsRecyclerView = participantsActivity.participantsRecyclerView
        assertTrue(participantsRecyclerView.layoutManager is LinearLayoutManager)
    }

    @Test
    fun shouldHaveRobotoLightFont() {
        val readyTextView = participantsActivity.readyTextView
        val typeface = Typeface.createFromAsset(participantsActivity.assets, "fonts/Roboto-Light.ttf")
        assertEquals(readyTextView.typeface, typeface)
    }

}