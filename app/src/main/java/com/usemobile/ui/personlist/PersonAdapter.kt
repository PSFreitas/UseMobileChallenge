package com.usemobile.ui.personlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.data.network.entities.PersonItemListNetworkEntity
import com.usemobile.R
import com.usemobile.databinding.ItemPersonBindingImpl

class PersonAdapter(
    val persons: MutableList<PersonItemListNetworkEntity>
) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                R.layout.item_person,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = persons.size

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) =
        holder.bind(person = persons[position])


    class PersonViewHolder(val binding: ItemPersonBindingImpl) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(person: PersonItemListNetworkEntity) {
            binding.person = person
        }
    }
}