package com.usemobile.ui.persondetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.usemobile.R
import com.usemobile.databinding.FragmentPersonDetailBinding
import kotlinx.android.synthetic.main.fragment_person_detail.*

class PersonDetailFragment : Fragment() {

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
        setupToolbar()

    }

    private fun setupToolbar() {
        if (arguments != null)
            toolbar_person_detail.title = arguments?.getString("toolbarDetailTitle")

    }

}