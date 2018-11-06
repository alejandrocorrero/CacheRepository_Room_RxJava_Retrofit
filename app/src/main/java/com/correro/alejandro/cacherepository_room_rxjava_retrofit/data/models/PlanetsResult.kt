package com.correro.alejandro.cacherepository_room_rxjava_retrofit.data.models

import com.google.gson.annotations.SerializedName

data class PlanetsResult(
        @SerializedName("count") val count: Int?,
        @SerializedName("next") val next: String?,
        @SerializedName("results") val results: ArrayList<Result>?
)