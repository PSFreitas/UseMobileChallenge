package com.usemobile.ui.persondetail

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
import com.usemobile.databinding.FragmentPersonDetailBinding
import com.usemobile.valuableobject.Status

class PersonDetailFragment : Fragment() {

    private val viewModel by lazy {
        val repositoryImpl = PersonRepositoryImpl(PersonClient.personService)
        PersonDetailViewModelFactory(
            repositoryImpl
        ).create(
            PersonDetailViewModel::class.java
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = DataBindingUtil.inflate<
            FragmentPersonDetailBinding>(
        inflater,
        R.layout.fragment_person_detail,
        container,
        false
    ).let {
        it.lifecycleOwner = viewLifecycleOwner
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchUserDetails()
        setupObservables()
    }

    private fun setupObservables() {
        viewModel.personDetail.observe(
            viewLifecycleOwner,
            Observer {
                if (it.status == Status.SUCCESS) {

                } else if (it.status == Status.ERROR) {
                    Snackbar.make(
                        requireView(),
                        it.exception?.message ?: "",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        )
    }

    private fun fetchUserDetails() {
        viewModel.getPersonDetails(
            arguments?.getInt("personId") ?: 0
        )
    }


}