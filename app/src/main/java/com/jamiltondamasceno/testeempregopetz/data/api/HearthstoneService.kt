package com.jamiltondamasceno.testeempregopetz.data.api

import com.jamiltondamasceno.testeempregopetz.data.model.Carta
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.PATCH
import retrofit2.http.Path

interface HearthstoneService {

    @GET("cards/sets/{conjunto}")
    suspend fun recuperarCartoes(
        @Path("conjunto") conjunto: String
    ) : Response<List<Carta>>

}