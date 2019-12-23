package br.com.chucknorris.category.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import br.com.chucknorris.category.databinding.ViewHolderCategoryBinding

class CategoryAdapter(
    private val categoryListener: CategoryListener
) : ListAdapter<CategoryView, CategoryViewHolder>(CategoryDiffUtil()) {

    private val categories = mutableListOf<CategoryView>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ViewHolderCategoryBinding.inflate(layoutInflater, parent, false)
        return CategoryViewHolder(binding, categoryListener)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val travelStopLocation = categories[position]
        holder.onBind(travelStopLocation)
    }

    override fun submitList(list: MutableList<CategoryView>?) {
        super.submitList(list)
        list?.let {
            categories.clear()
            categories.addAll(list)
        }
    }

    override fun getItemCount() = categories.size
}