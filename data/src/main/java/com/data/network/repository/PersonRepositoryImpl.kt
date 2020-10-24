package com.data.network.repository

import com.data.ResultData
import com.data.network.ErrorNetwork
import com.data.network.api.PersonService
import com.data.network.entities.PersonDetailNetworkEntity
import com.data.network.entities.PersonListNetworkEntity
import com.google.gson.Gson


class PersonRepositoryImpl(
    private val personService: PersonService
) {
    suspend fun getPersonList(): ResultData<PersonListNetworkEntity> {
        try {
            val response = personService.getUserList()
            return if (response.isSuccessful) {
                if (response.body() != null) {
                    val personList = response.body() as PersonListNetworkEntity
                    ResultData.Success(personList)
                } else {
                    ResultData.Error(exception = Exception())
                }

            } else {
                ResultData.Error(exception = Exception())
            }
        } catch (exception: Exception) {
            return ResultData.Error(exception = exception)
        }

    }

    suspend fun getPersonDetail(
        userId: String
    ): ResultData<PersonDetailNetworkEntity> {
        try {
            val response = personService.getUserDetail(userId)
            return if (response.isSuccessful) {
                if (response.body() != null) {
                    val personDetail = response.body() as PersonDetailNetworkEntity
                    ResultData.Success(personDetail)
                } else {
                    ResultData.Error(exception = Exception())
                }
            } else {
                val errorNetwork: ErrorNetwork = Gson().fromJson(
                    response.errorBody()?.string(),
                    ErrorNetwork::class.java
                )
                ResultData.Error(exception = Exception(errorNetwork.error))
            }
        } catch (exception: Exception) {
            return ResultData.Error(exception = exception)
        }
    }
}