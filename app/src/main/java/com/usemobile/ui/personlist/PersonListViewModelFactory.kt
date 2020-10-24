package com.usemobile.ui.personlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.data.network.repository.PersonRepositoryImpl

@Suppress("UNCHECKED_CAST")
class PersonListViewModelFactory(
    private val repositoryImpl: PersonRepositoryImpl
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PersonListViewModel(
            repositoryImpl
        ) as T
    }
}