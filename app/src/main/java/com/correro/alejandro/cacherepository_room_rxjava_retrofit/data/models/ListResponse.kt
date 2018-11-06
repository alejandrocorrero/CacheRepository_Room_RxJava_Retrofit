package com.example.fitcel.fitcel.data.models

import com.google.gson.annotations.SerializedName

data class ListResponse<T>(
        @SerializedName("total") val total: Int,
        @SerializedName("rows") val rows: ArrayList<T>,
        @SerializedName("summary") val summary: List<Any>
)