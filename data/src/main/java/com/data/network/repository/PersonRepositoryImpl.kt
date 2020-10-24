package com.data.network.repository

import com.data.ResultData
import com.data.network.api.PersonService
import com.data.network.entities.PersonListNetworkEntity

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
}