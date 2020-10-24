package com.usemobile.ui.persondetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.data.ResultData
import com.data.network.entities.PersonDetailNetworkEntity
import com.data.network.repository.PersonRepositoryImpl
import com.usemobile.valuableobject.Resource
import kotlinx.coroutines.launch

class PersonDetailViewModel(
    private val repositoryImpl: PersonRepositoryImpl
) : ViewModel() {

    val personDetail = MutableLiveData<Resource<PersonDetailNetworkEntity>>()

    fun getPersonDetails(
        userId: String
    ) {
        personDetail.value = Resource.loading()
        viewModelScope.launch {
            val response = repositoryImpl.getPersonDetail(userId)

            if (response is ResultData.Success) {
                personDetail.value = Resource.success(response.data)
            } else if(response is ResultData.Error) {
                personDetail.value = Resource.error(response.exception)
            }
        }
    }
}