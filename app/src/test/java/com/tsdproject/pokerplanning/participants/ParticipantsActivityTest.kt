package com.tsdproject.pokerplanning.participants

import android.graphics.Typeface
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import com.tsdproject.pokerplanning.R
import junit.framework.Assert.*
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
        val participantsRecyclerView = participantsActivity.findViewById<RecyclerView>(R.id.participantsRecyclerView)
        assertNotNull(participantsRecyclerView.adapter)
    }

    @Test
    fun recyclerViewShouldHaveLinearLayoutManager() {
        val participantsRecyclerView = participantsActivity.findViewById<RecyclerView>(R.id.participantsRecyclerView)
        assertTrue(participantsRecyclerView.layoutManager is LinearLayoutManager)
    }

    @Test
    fun shouldHaveRobotoLightFont() {
        val readyTextView = participantsActivity.findViewById<TextView>(R.id.readyTextView)
        val typeface = Typeface.createFromAsset(participantsActivity.assets, "fonts/Roboto-Light.ttf")
        assertEquals(readyTextView.typeface, typeface)
    }

}