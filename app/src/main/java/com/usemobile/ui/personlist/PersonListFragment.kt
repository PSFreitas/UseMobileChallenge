package com.usemobile.ui.personlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.data.network.api.PersonClient
import com.data.network.repository.PersonRepositoryImpl
import com.usemobile.R
import com.usemobile.databinding.FragmentPersonListBinding
import com.usemobile.valuableobject.Status
import kotlinx.android.synthetic.main.fragment_person_list.*

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

    private val adapter: PersonAdapter = PersonAdapter(mutableListOf())


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
        it.viewModel = viewModel
        it.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservables()
        fetchPersonsFromApi()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView_person_list.adapter = adapter
        recyclerView_person_list.layoutManager = LinearLayoutManager(
            requireContext(),
            RecyclerView.VERTICAL,
            false
        )
        if (recyclerView_person_list.itemDecorationCount == 0) {
            recyclerView_person_list.addItemDecoration(
                DividerItemDecoration(requireContext(), RecyclerView.VERTICAL).apply {
                    ContextCompat.getDrawable(
                        requireContext(), R.drawable.item_divider
                    )?.let {
                        this.setDrawable(
                            it
                        )
                    }
                }
            )

        }
    }

    private fun fetchPersonsFromApi() {
        viewModel.fetchPersonListFromApi()
    }

    private fun setupObservables() {
        viewModel.personList.observe(
            viewLifecycleOwner, Observer {
                if (it.status == Status.SUCCESS) {
                    adapter.persons.addAll(it.data?.personList!!)
                    adapter.notifyDataSetChanged()
                }
            }
        )
    }
}