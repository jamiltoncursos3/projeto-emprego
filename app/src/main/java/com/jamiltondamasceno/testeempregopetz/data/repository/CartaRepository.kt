package com.jamiltondamasceno.testeempregopetz.data.repository

import com.jamiltondamasceno.testeempregopetz.data.model.Carta

interface CartaRepository {
    suspend fun recuperarCartas() : List<Carta>
}