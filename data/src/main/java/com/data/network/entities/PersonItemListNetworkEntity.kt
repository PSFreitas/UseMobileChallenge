package com.data.network.entities

import com.google.gson.annotations.SerializedName

/**
 * Class that represent a person when fetch person list from API.
 *
 *  @property id of the person
 *  @property name of the person
 *  @property photo url of the person
 *  @property email of the person
 *  @property isVerified if the person has a verified account
 * */

data class PersonItemListNetworkEntity(
    @SerializedName("id") var id: Int,
    @SerializedName("name") var name: String,
    @SerializedName("photo") var photo: String,
    @SerializedName("email") var email: String,
    @SerializedName("isVerified") var isVerified: Boolean
)