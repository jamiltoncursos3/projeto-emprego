package com.jamiltondamasceno.testeempregopetz.data.api

import okhttp3.Interceptor
import okhttp3.Response

class BaseInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val requisicaoBuilder = chain.request().newBuilder()

        requisicaoBuilder.addHeader(
            "X-RapidAPI-Key", "97655c867fmsh5ae27313bed6f5ap1dd9c1jsn01df994d68b8"
        )
        requisicaoBuilder.addHeader(
            "X-RapidAPI-Host", "omgvamp-hearthstone-v1.p.rapidapi.com"
        )

        return chain.proceed( requisicaoBuilder.build() )

    }
}