package com.data.network.api

import com.data.network.entities.PersonListNetworkEntity
import retrofit2.Response
import retrofit2.http.GET

interface PersonService {

    @GET("user")
    suspend fun getUserList(): Response<PersonListNetworkEntity>

}