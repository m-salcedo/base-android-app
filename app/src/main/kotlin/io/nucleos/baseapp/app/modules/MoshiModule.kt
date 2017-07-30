package io.nucleos.baseapp.app.modules

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import io.nucleos.baseapp.app.di.AppScope
import io.nucleos.baseapp.app.di.FlatObjectsQualifier

/**
 * Created by Mariangela Salcedo (mariangela@nucleos.io) on 7/29/17.
 * Copyright (c) 2017 Nucelos IO. All rights reserved.
 */
@Module
class MoshiModule {
    @Provides
    @AppScope
    fun provideMoshi(): Moshi = Moshi.Builder().build()

    @Provides
    @AppScope
    @FlatObjectsQualifier
    fun provideMoshiFlatObjects(): Moshi {
        return Moshi.Builder()
                .build()
    }
}