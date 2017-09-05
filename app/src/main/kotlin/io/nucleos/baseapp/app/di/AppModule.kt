package io.nucleos.baseapp.app.di

import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import io.nucleos.baseapp.app.Application

/**
 * Created by Mariangela Salcedo (mariangela@nucleos.io) on 7/29/17.
 * Copyright (c) 2017 Nucelos IO. All rights reserved.
 */
@Module
class AppModule(private val app: Application) {

    @Provides
    @AppScope
    fun provideApp(): Application = app

    @Provides
    @AppScope
    @AppQualifier
    fun provideApplicationContext(): Context = app

    @Provides
    @AppScope
    fun provideResources(): Resources = app.resources
}