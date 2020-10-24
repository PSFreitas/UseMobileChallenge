package com.data.network.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface PersonClient {

    companion object {

        private const val BASE_URL = "https://processo-seletivo-mobile-api.usemobile.com.br/api/"

        private val retrofit: Retrofit by lazy {
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()
            ).build()
        }

        val personService: PersonService by lazy {
            retrofit.create(PersonService::class.java)
        }

    }

}