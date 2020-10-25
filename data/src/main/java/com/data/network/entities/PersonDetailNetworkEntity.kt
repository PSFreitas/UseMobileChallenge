package com.data.network.entities

import com.google.gson.annotations.SerializedName

data class PersonDetailNetworkEntity(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("photo") val photo: String,
    @SerializedName("email") val email: String,
    @SerializedName("about") val about: String
)