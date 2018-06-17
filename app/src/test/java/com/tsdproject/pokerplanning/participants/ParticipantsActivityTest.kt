package com.tsdproject.pokerplanning.participants

import android.graphics.Typeface
import android.support.v7.widget.LinearLayoutManager
import com.nhaarman.mockito_kotlin.anyOrNull
import com.nhaarman.mockito_kotlin.whenever
import com.tsdproject.pokerplanning.model.transportobjects.UserTO
import com.tsdproject.pokerplanning.service.ServiceProvider
import com.tsdproject.pokerplanning.service.api.PlayTablesApi
import junit.framework.Assert.*
import kotlinx.android.synthetic.main.activity_participants.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import rx.Observable

@RunWith(RobolectricTestRunner::class)
class ParticipantsActivityTest {

    lateinit var participantsActivity: ParticipantsActivity

    @Mock
    private var playTablesApi = Mockito.mock(PlayTablesApi::class.java)

    @Before
    fun initData() {
        whenever(playTablesApi.getParticipants(anyOrNull())).thenReturn(
            Observable.just(listOf(UserTO(0,"","","")))
        )

        ServiceProvider.playTablesService = playTablesApi

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