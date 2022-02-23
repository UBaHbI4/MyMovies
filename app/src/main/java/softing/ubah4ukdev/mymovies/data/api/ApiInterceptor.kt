package softing.ubah4ukdev.mymovies.data.api

import okhttp3.Interceptor
import okhttp3.Response

/**
 *   Project: City terminal
 *
 *   Package: softing.ubah4ukdev.cityterminal.data.apiservice.cashier
 *
 *   Created by Ivan Sheynmaer
 *
 *   Description:
 *
 *
 *   2022.01.20
 *
 *   v1.0
 */
class ApiInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response =
        chain.proceed(
            chain.request()
                .newBuilder()
                .build()
        )
}