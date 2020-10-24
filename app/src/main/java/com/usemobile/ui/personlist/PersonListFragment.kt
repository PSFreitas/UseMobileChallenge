package com.usemobile.ui.personlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.usemobile.R
import com.usemobile.databinding.FragmentPersonListBinding

class PersonListFragment : Fragment() {

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
}