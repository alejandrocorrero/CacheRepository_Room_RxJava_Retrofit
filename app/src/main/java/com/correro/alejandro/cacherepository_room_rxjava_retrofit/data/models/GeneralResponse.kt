package com.example.fitcel.fitcel.data.models

import com.google.gson.annotations.SerializedName

data class GeneralResponse<T>(
        @SerializedName("status") val status: Int,
        @SerializedName("type") val type: Int,
        @SerializedName("message") val message: String,
        @SerializedName("data") val data: T)