package io.nucleos.baseapp.app.modules

import android.content.Context
import com.jakewharton.picasso.OkHttp3Downloader
import io.nucleos.baseapp.app.di.AppScope
import com.squareup.picasso.Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import io.nucleos.baseapp.app.di.AppModule
import io.nucleos.baseapp.app.di.AppQualifier
import io.nucleos.baseapp.app.modules.network.NetworkModule
import okhttp3.OkHttpClient

/**
 * Created by Mariangela Salcedo (mariangela@nucleos.io) on 7/29/17.
 * Copyright (c) 2017 Nucelos IO. All rights reserved.
 */
@Module(includes = arrayOf(NetworkModule::class, AppModule::class))
class PicassoModule {

    @Provides
    @AppScope
    fun provideDownloader(okHttpClient: OkHttpClient): Downloader = OkHttp3Downloader(okHttpClient)

    @Provides
    @AppScope
    fun providePicasso(@AppQualifier context: Context, downloader: Downloader): Picasso =
            Picasso.Builder(context)
                    .downloader(downloader)
                    .build()
}