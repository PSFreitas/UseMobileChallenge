package com.usemobile.ui.personlist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.data.network.entities.PersonItemListNetworkEntity
import com.usemobile.R
import com.usemobile.databinding.ItemPersonBindingImpl

class PersonAdapter(
    val persons: MutableList<PersonItemListNetworkEntity>
) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    private val cleanListState = mutableListOf<PersonItemListNetworkEntity>()
    lateinit var onPersonClickListener: OnPersonClickListener

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
        holder.bind(person = persons[position], personClickListener = onPersonClickListener)


    fun addElements(elementsToBeAdded: List<PersonItemListNetworkEntity>) {
        persons.addAll(elementsToBeAdded)
        cleanListState.addAll(elementsToBeAdded)
        notifyDataSetChanged()
    }

    fun getFilter() = object : Filter() {
        override fun performFiltering(charSequence: CharSequence?): FilterResults {
            val nameToBeSearched: String = charSequence.toString()
            if (nameToBeSearched.isEmpty()) {
                persons.addAll(cleanListState)
            } else {
                persons.clear()
                for (person in cleanListState) {
                    if (person.name.toLowerCase().contains(nameToBeSearched.toLowerCase())) {
                        persons.add(person)
                    }
                }
            }

            val filterResults = FilterResults()
            filterResults.values = persons
            return filterResults
        }

        override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults?) {
            notifyDataSetChanged()
        }

    }


    class PersonViewHolder(val binding: ItemPersonBindingImpl) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            person: PersonItemListNetworkEntity,
            personClickListener: OnPersonClickListener
        ) {
            binding.person = person
            binding.root.setOnClickListener {
                personClickListener.onPersonClick(personId = person.id, personName = person.name)
            }
        }
    }

}