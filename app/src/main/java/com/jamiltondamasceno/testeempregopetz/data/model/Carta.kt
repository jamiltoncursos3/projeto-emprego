package com.jamiltondamasceno.testeempregopetz.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Carta(
    val attack: Int,
    val cardId: String,
    val cardSet: String,
    val cost: Int,
    val dbfId: Int,
    val health: Int,
    val img: String,
    val locale: String,
    val name: String,
    val playerClass: String,
    val race: String,
    val text: String,
    val type: String
) : Parcelable