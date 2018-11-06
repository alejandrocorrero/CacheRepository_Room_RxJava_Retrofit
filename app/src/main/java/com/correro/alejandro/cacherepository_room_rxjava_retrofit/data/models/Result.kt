package com.correro.alejandro.cacherepository_room_rxjava_retrofit.data.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "result")
data class Result(
        @PrimaryKey(autoGenerate = false)
        @SerializedName("name") val name: String,
        @SerializedName("model") val model: String?,
        @SerializedName("manufacturer") val manufacturer: String?,
        @SerializedName("cost_in_credits") val costInCredits: String?,
        @SerializedName("length") val length: String?,
        @SerializedName("max_atmosphering_speed") val maxAtmospheringSpeed: String?,
        @SerializedName("crew") val crew: String?,
        @SerializedName("passengers") val passengers: String?,
        @SerializedName("cargo_capacity") val cargoCapacity: String?,
        @SerializedName("consumables") val consumables: String?,
        @SerializedName("hyperdrive_rating") val hyperdriveRating: String?,
        @SerializedName("MGLT") val mGLT: String?,
        @SerializedName("starship_class") val starshipClass: String?,
        @SerializedName("created") val created: String?,
        @SerializedName("edited") val edited: String?,
        @SerializedName("url") val url: String?
)