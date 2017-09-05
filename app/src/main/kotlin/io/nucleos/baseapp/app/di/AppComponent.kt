package io.nucleos.baseapp.app.di

import android.content.res.Resources
import com.google.android.gms.analytics.Tracker
import com.squareup.moshi.Moshi
import com.squareup.picasso.Picasso
import dagger.Component
import io.nucleos.baseapp.app.Application
import io.nucleos.baseapp.app.modules.AnalyticsModule
import io.nucleos.baseapp.app.modules.MoshiModule
import io.nucleos.baseapp.app.modules.PicassoModule
import io.nucleos.baseapp.app.modules.api.ApiModule
import io.nucleos.baseapp.app.modules.api.TestApi

/**
 * Created by Mariangela Salcedo (mariangela@nucleos.io) on 7/29/17.
 * Copyright (c) 2017 Nucelos IO. All rights reserved.
 */
@AppScope
@Component(modules = arrayOf(PicassoModule::class, MoshiModule::class, AnalyticsModule::class, ApiModule::class))
interface AppComponent {
    fun inject(app: Application): Unit
    fun picasso(): Picasso
    fun moshi(): Moshi
    fun resources(): Resources
    fun tracker(): Tracker
    fun testApi(): TestApi
}