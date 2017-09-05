package io.nucleos.baseapp.app.modules.network

import android.content.Context
import io.nucleos.baseapp.app.di.AppQualifier
import io.nucleos.baseapp.app.di.AppScope
import io.nucleos.baseapp.ui.splash.SplashActivity
import io.nucleos.baseapp.common.storage.SessionManager
import io.nucleos.baseapp.utils.Constant
import okhttp3.Interceptor
import okhttp3.Response
import org.jetbrains.anko.intentFor
import javax.inject.Inject

/**
 * Created by Mariangela Salcedo (mariangela@nucleos.io) on 7/29/17.
 * Copyright (c) 2017 Nucelos IO. All rights reserved.
 */
@AppScope
class AuthenticationInterceptor @Inject constructor(
        @AppQualifier val context: Context,
        val sessionManager: SessionManager
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response? {

        val request = chain
                ?.request()
                ?.newBuilder()
                ?.addHeader(Constant.Key.AUTHORIZATION, Constant.Key.JWT + sessionManager.token)
                ?.build()

        val response = chain?.proceed(request)
        val code = response?.code()

        if (code == Constant.Network.Status.UNAUTHORIZED ||
                code == Constant.Network.Status.FORBIDDEN) {
            context.apply { startActivity(intentFor<SplashActivity>()) }
        }

        return response
    }
}