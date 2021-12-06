package ru.oliverhd.kudagoevents.categorieslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.oliverhd.kudagoevents.R
import ru.oliverhd.kudagoevents.categorieslist.CategoriesListAdapter.CategoriesListViewHolder
import ru.oliverhd.kudagoevents.databinding.CategoriesListItemBinding
import ru.oliverhd.kudagoevents.model.EventCategory

class CategoriesListAdapter(
    private val delegate: Delegate?
) : ListAdapter<EventCategory, CategoriesListViewHolder>(CategoryDiff) {

    interface Delegate {
        fun onCategoryClicked(category: EventCategory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesListViewHolder =
        CategoriesListViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.categories_list_item, parent, false)
        )

    override fun onBindViewHolder(holder: CategoriesListViewHolder, position: Int) =
        holder.bind(getItem(position), delegate)

    class CategoriesListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val viewBinding: CategoriesListItemBinding by viewBinding()

        fun bind(category: EventCategory, delegate: Delegate?) {
            with(viewBinding) {
                categoriesListItemTextView.text = category.name
                categoriesListItemTextView.setOnClickListener {
                    delegate?.onCategoryClicked(category)
                }
            }
        }
    }
}