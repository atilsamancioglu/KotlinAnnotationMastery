package com.atilsamancioglu.annotationmastery.util

import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Invocation

class AuthenticationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val invocation = chain.request().tag(Invocation::class.java) ?: return chain.proceed(chain.request())
        val shouldAddAuthHeader = invocation
            .method()
            .annotations
            .any {it.annotationClass == AuthTokenNeeded::class}

        return if(shouldAddAuthHeader) {
            chain.proceed(
                chain
                    .request()
                    .newBuilder()
                    .addHeader("Auth","TOKEN_VALUE")
                    .build()
            )
        } else {
            chain.proceed(chain.request())
        }
    }

}