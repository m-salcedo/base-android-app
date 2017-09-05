package io.nucleos.baseapp.common.notifications

import com.onesignal.OneSignal
import io.reactivex.Single
import io.reactivex.SingleObserver

class RxOneSignal {

    companion object {
        val userId: Single<String> = object: Single<String>() {
            override fun subscribeActual(observer: SingleObserver<in String>?) {
                OneSignal.idsAvailable { userId, _ -> observer?.onSuccess(userId) }
            }
        }
    }
}
