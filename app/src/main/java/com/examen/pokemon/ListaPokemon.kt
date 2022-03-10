package com.examen.pokemon

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class ListaPokemon (
    val count: Long,
    val next: String,
    val results: List<Result>
) : Parcelable

@Parcelize
data class Result (
    val name: String,
    val url: String
) : Parcelable
