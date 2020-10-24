package com.data.network.entities

import com.google.gson.annotations.SerializedName

/**
 * A class that holds the person list when fetch from API
 * */
data class PersonListNetworkEntity(
    @SerializedName("result") val personList: List<PersonItemListNetworkEntity>
)