package com.usemobile.ui.personlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.data.network.api.PersonClient
import com.data.network.repository.PersonRepositoryImpl
import com.google.android.material.snackbar.Snackbar
import com.usemobile.R
import com.usemobile.databinding.FragmentPersonListBinding
import com.usemobile.valuableobject.Status

class PersonListFragment : Fragment() {

    private val viewModel: PersonListViewModel by lazy {
        val personRepositoryImpl = PersonRepositoryImpl(
            personService = PersonClient.personService
        )
        PersonListViewModelFactory(
            personRepositoryImpl
        ).create(
            PersonListViewModel::class.java
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = DataBindingUtil.inflate<FragmentPersonListBinding>(
        inflater,
        R.layout.fragment_person_list,
        container,
        false
    ).let {
        it.lifecycleOwner = viewLifecycleOwner
        it.root
    }

    override fun onResume() {
        super.onResume()
        setupObservables()
        fetchPersonsFromApi()
    }

    private fun fetchPersonsFromApi() {
        viewModel.fetchPersonListFromApi()
    }

    private fun setupObservables() {
        viewModel.personList.observe(
            this, Observer {
            }
        )
    }
}