package com.tsdproject.pokerplanning.splashTest

import android.os.Handler
import com.nhaarman.mockito_kotlin.whenever
import com.tsdproject.pokerplanning.service.ServiceProvider
import com.tsdproject.pokerplanning.service.api.DynamicAddressApi
import com.tsdproject.pokerplanning.splash.SplashActivity
import com.tsdproject.pokerplanning.splash.SplashPresenter
import com.tsdproject.pokerplanning.splash.SplashPresenterImpl
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import rx.Observable

@RunWith(RobolectricTestRunner::class)
class SplashPresenterTest {

    lateinit var splashPresenter: SplashPresenter
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
        splashPresenter = SplashPresenterImpl(splashActivity)
    }

    @Test
    fun shouldActivityNotBeNull() {
        assertNotNull(splashActivity)
    }

    @Test
    fun shouldPresenterNotBeNull() {
        assertNotNull(splashPresenter)
    }

    @Test
    fun shouldBeDoneInOneAndHalfSecond() {
        val sleepTime: Long = 1500
        var value = false
        splashPresenter.handleSplashScreen { value = true }
        Handler().postDelayed({
            assertTrue(value)
        }, sleepTime)
    }
}