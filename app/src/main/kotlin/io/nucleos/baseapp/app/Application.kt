package io.nucleos.baseapp.app

import android.support.multidex.MultiDexApplication
import com.google.android.gms.analytics.Tracker
import com.onesignal.OneSignal
import io.nucleos.baseapp.R
import io.nucleos.baseapp.app.di.AppComponent
import io.nucleos.baseapp.app.di.AppModule
import io.nucleos.baseapp.app.di.DaggerAppComponent
import io.nucleos.baseapp.common.notifications.NotificationReceivedHandler
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import javax.inject.Inject

/**
 * Created by Mariangela Salcedo (mariangela@nucleos.io) on 7/28/17.
 * Copyright (c) 2017 Nucelos IO. All rights reserved.
 */
class Application : MultiDexApplication() {

    private val TAG = "TAG_${Application::class.java.simpleName}"

    companion object {
        lateinit var component: AppComponent
    }

    @Inject
    lateinit var notificationReceivedHandler: NotificationReceivedHandler

    @Inject
    lateinit var tracker: Tracker

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()

        component.inject(this)

        tracker.enableAutoActivityTracking(false)
        tracker.enableAdvertisingIdCollection(true)

        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
                .setDefaultFontPath(getString(R.string.font_regular))
                .setFontAttrId(R.attr.fontPath)
                .build())

        OneSignal.startInit(this)
                .setNotificationReceivedHandler(notificationReceivedHandler)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.None)
                .init()
    }
}