package com.usemobile.ui.persondetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.data.network.repository.PersonRepositoryImpl

@Suppress("UNCHECKED_CAST")
class PersonDetailViewModelFactory(
    private val repositoryImpl: PersonRepositoryImpl
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PersonDetailViewModel(
            repositoryImpl
        ) as T
    }

}