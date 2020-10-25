package com.data.network

import com.google.gson.annotations.SerializedName

data class ErrorNetwork(
    @SerializedName("error") val error: String
)