package com.data.network.api

import com.data.network.entities.PersonDetailNetworkEntity
import com.data.network.entities.PersonListNetworkEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PersonService {

    @GET("user")
    suspend fun getUserList(): Response<PersonListNetworkEntity>

    @GET("user/:{id}")
    suspend fun getUserDetail(
        @Path("id") userId: Int
    ): Response<PersonDetailNetworkEntity>

}