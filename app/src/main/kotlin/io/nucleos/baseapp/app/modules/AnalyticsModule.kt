package io.nucleos.baseapp.app.modules

import android.content.Context
import com.google.android.gms.analytics.GoogleAnalytics
import com.google.android.gms.analytics.Tracker
import dagger.Module
import dagger.Provides
import io.nucleos.baseapp.R
import io.nucleos.baseapp.app.di.AppQualifier
import io.nucleos.baseapp.app.di.AppScope

/**
 * Created by Mariangela Salcedo (mariangela@nucleos.io) on 7/29/17.
 * Copyright (c) 2017 Nucelos IO. All rights reserved.
 */
@Module
class AnalyticsModule {

    @Provides
    @AppScope
    fun provideGoogleAnalytics(@AppQualifier context: Context): GoogleAnalytics = GoogleAnalytics.getInstance(context)

    @Provides
    @AppScope
    fun provideTracker(googleAnalytics: GoogleAnalytics): Tracker = googleAnalytics.newTracker(R.xml.global_tracker)
}