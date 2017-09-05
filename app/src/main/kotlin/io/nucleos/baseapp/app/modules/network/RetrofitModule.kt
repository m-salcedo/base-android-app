package io.nucleos.baseapp.app.modules.network

import android.content.res.Resources
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import io.nucleos.baseapp.R
import io.nucleos.baseapp.app.di.AppScope
import io.nucleos.baseapp.app.di.AuthenticationQualifier
import io.nucleos.baseapp.app.di.BaseUrlQualifier
import io.nucleos.baseapp.app.di.FlatObjectsQualifier
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module(includes = arrayOf(NetworkModule::class))
class RetrofitModule {

    @Provides
    @AppScope
    @BaseUrlQualifier
    fun provideBaseUrl(resources: Resources): String = resources.getString(R.string.url_api_current)

    @Provides
    @AppScope
    fun provideConverterFactory(@FlatObjectsQualifier moshi: Moshi): Converter.Factory =
            MoshiConverterFactory.create(moshi)

    @Provides
    @AppScope
    fun provideCallAdapterFactory(): CallAdapter.Factory = RxJava2CallAdapterFactory.create()

    @Provides
    @AppScope
    @AuthenticationQualifier
    fun provideAuthenticatedRetrofit(
            @BaseUrlQualifier baseUrl: String,
            @AuthenticationQualifier client: OkHttpClient,
            converter: Converter.Factory,
            callAdapter: CallAdapter.Factory): Retrofit =
            Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(client)
                    .addConverterFactory(converter)
                    .addCallAdapterFactory(callAdapter)
                    .build()

    @Provides
    @AppScope
    fun provideRetrofit(
            @BaseUrlQualifier baseUrl: String,
            client: OkHttpClient,
            converter: Converter.Factory,
            callAdapter: CallAdapter.Factory): Retrofit =
            Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(client)
                    .addConverterFactory(converter)
                    .addCallAdapterFactory(callAdapter)
                    .build()
}
