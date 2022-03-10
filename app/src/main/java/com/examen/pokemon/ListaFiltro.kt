package com.examen.pokemon

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.JsonArray
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName

@Parcelize
data class ListaFiltro (
    @SerialName("damage_relations")
    val damageRelations: DamageRelations,

    @SerialName("game_indices")
    val gameIndices: List<GameIndex>,

    val generation: Generation,
    val id: Long,

    @SerialName("move_damage_class")
    val moveDamageClass: Generation,

    val moves: List<Generation>,
    val name: String,
    val names: List<Name>,

  /*  @SerialName("past_damage_relations")
    val pastDamageRelations: JsonArray,
*/

    val pokemon: List<Pokemon>
): Parcelable

@Parcelize
data class DamageRelations (
    @SerialName("double_damage_from")
    val doubleDamageFrom: List<Generation>,

    @SerialName("double_damage_to")
    val doubleDamageTo: List<Generation>,

    @SerialName("half_damage_from")
    val halfDamageFrom: List<Generation>,

    @SerialName("half_damage_to")
    val halfDamageTo: List<Generation>,

    @SerialName("no_damage_from")
    val noDamageFrom: List<Generation>,

    @SerialName("no_damage_to")
    val noDamageTo: List<Generation>
) : Parcelable

@Parcelize
data class Generation (
    val name: String,
    val url: String
): Parcelable

@Parcelize
data class GameIndex (
    @SerialName("game_index")
    val gameIndex: Long,

    val generation: Generation
) : Parcelable

@Parcelize
data class Name (
    val language: Generation,
    val name: String
): Parcelable

@Parcelize
data class Pokemon (
    val pokemon: Generation,
    val slot: Long
): Parcelable
