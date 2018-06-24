package com.tsdproject.pokerplanning.splashTest

import android.graphics.Typeface
import com.nhaarman.mockito_kotlin.whenever
import com.tsdproject.pokerplanning.service.ServiceProvider
import com.tsdproject.pokerplanning.service.api.DynamicAddressApi
import com.tsdproject.pokerplanning.splash.SplashActivity
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import kotlinx.android.synthetic.main.activity_splash.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import rx.Observable

@RunWith(RobolectricTestRunner::class)
class SplashActivityTest {

    lateinit var splashActivity: SplashActivity

    @Mock
    private var dynamicAddressApi = Mockito.mock(DynamicAddressApi::class.java)

    @Before
    fun initData() {
        whenever(dynamicAddressApi.getDynamicAddress()).thenReturn(
            Observable.just("")
        )

        ServiceProvider.dynamicAddressService = dynamicAddressApi

        splashActivity = Robolectric.setupActivity(SplashActivity::class.java)
    }

    @Test
    fun shouldNotBeNull() {
        assertNotNull(splashActivity)
    }

    @Test
    fun shouldHaveRegularFont() {
        val appNameTextView = splashActivity.appNameTextView
        val typeface = Typeface.createFromAsset(splashActivity.assets, "fonts/SourceCodePro-Regular.ttf")
        assertEquals(appNameTextView.typeface, typeface)
    }
}