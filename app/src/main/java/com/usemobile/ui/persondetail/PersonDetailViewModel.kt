package com.usemobile.ui.persondetail

import androidx.lifecycle.ViewModel
import com.data.network.repository.PersonRepositoryImpl

class PersonDetailViewModel(
    private val repositoryImpl: PersonRepositoryImpl
) : ViewModel() {
}