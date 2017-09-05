package io.nucleos.baseapp.app.modules.api


import dagger.Module
import dagger.Provides
import io.nucleos.baseapp.app.di.AppScope
import io.nucleos.baseapp.app.modules.network.RetrofitModule
import retrofit2.Retrofit

@Module(includes = arrayOf(RetrofitModule::class))
class ApiModule {

    @Provides
    @AppScope
    fun provideAuthApi(retrofit: Retrofit): TestApi = retrofit.create(TestApi::class.java)

}