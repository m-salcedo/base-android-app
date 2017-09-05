package io.nucleos.baseapp.app.modules.api

import io.nucleos.baseapp.utils.Constant
import io.reactivex.Single
import retrofit2.http.GET

interface TestApi {
    @GET(Constant.Url.Auth.BASE)
    fun test(): Single<Any>
}