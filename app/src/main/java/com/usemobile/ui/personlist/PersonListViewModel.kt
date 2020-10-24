package com.usemobile.ui.personlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.data.ResultData
import com.data.network.entities.PersonListNetworkEntity
import com.data.network.repository.PersonRepositoryImpl
import com.usemobile.valuableobject.Resource
import kotlinx.coroutines.launch

class PersonListViewModel(
    private val repositoryImpl: PersonRepositoryImpl
) : ViewModel() {


    val personList = MutableLiveData<Resource<PersonListNetworkEntity>>()


    fun fetchPersonListFromApi() {
        personList.value = Resource.loading()
        viewModelScope.launch {
            val response = repositoryImpl.getPersonList()

            if (response is ResultData.Success) {
                personList.value = Resource.success(response.data)
            } else {
                personList.value = Resource.error(Exception())
            }
        }
    }

}