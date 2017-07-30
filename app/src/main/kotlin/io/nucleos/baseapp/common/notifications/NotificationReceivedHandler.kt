package io.nucleos.baseapp.common.notifications

import android.content.Context
import android.util.Log
import com.onesignal.OSNotification
import com.onesignal.OneSignal
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import io.nucleos.baseapp.app.di.AppQualifier
import io.nucleos.baseapp.app.di.AppScope
import io.nucleos.baseapp.common.storage.SessionManager
import io.nucleos.baseapp.models.Session
import io.nucleos.baseapp.utils.Constant
import javax.inject.Inject

@AppScope
class NotificationReceivedHandler @Inject constructor(
        @AppQualifier val context: Context,
        val sessionManager: SessionManager,
        val moshi: Moshi) : OneSignal.NotificationReceivedHandler {

    private val TAG = "TAG_${NotificationReceivedHandler::class.java.simpleName}"
    private val sessionAdapter: JsonAdapter<Session> = moshi.adapter(Session::class.java)

    override fun notificationReceived(notification: OSNotification?) {
        if (sessionManager.isLoggedIn) {
            val additionalData = notification?.payload?.additionalData
            val event = additionalData?.getString(Constant.Key.EVENT)
            Log.i(TAG, "New notification(event): $event")
            when (event) {
            // events here
                else -> {
                    Log.d(TAG, "Unknown event: $event")
                }
            }
        }
    }
}