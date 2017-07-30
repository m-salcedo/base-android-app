package io.nucleos.baseapp.common.storage

import android.content.Context
import android.util.Log
import io.nucleos.baseapp.common.ext.saveString
import com.squareup.moshi.Moshi
import io.nucleos.baseapp.app.di.AppQualifier
import io.nucleos.baseapp.app.di.AppScope
import io.nucleos.baseapp.models.Session
import io.nucleos.baseapp.utils.Constant
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

/**
 * Created by Mariangela Salcedo (mariangela@nucleos.io) on 7/29/17.
 * Copyright (c) 2017 Nucelos IO. All rights reserved.
 */
@AppScope
class SessionManager @Inject constructor(@AppQualifier context: Context, moshi: Moshi) {

    private val TAG = "TAG_${SessionManager::class.java.simpleName}"

    private val preferences = context.getSharedPreferences(Constant.Preferences.SESSION, Context.MODE_PRIVATE)
    private val sessionSubject = PublishSubject.create<Session>()
    private val sessionAdapter = moshi.adapter(Session::class.java)

    val sessionObservable: Observable<Session> = sessionSubject

    val isLoggedIn: Boolean
        get() = preferences.getString(Constant.Key.ACCESS_TOKEN, "").isEmpty()

    var token: String
        get() = preferences.getString(Constant.Key.ACCESS_TOKEN, "")
        set(value) = preferences.saveString(Constant.Key.ACCESS_TOKEN, value)

    var session: Session?
        @Synchronized
        set(value) {
            if (value == null) {
                preferences.edit().remove(Constant.Key.SESSION).apply()
            }
            else {
                preferences.saveString(Constant.Key.SESSION, sessionAdapter.toJson(value))
                sessionSubject.onNext(value)
            }
        }
        get() {
            try {
                return sessionAdapter.fromJson(preferences.getString(Constant.Key.SESSION, ""))
            } catch (error: Exception) {
                Log.e(TAG, error.message)
                error.printStackTrace()
                return null
            }
        }

    fun clear() = preferences.edit().clear().apply()
}


