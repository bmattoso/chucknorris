package br.com.chucknorris.category.presentation

import androidx.recyclerview.widget.DiffUtil

class CategoryDiffUtil : DiffUtil.ItemCallback<CategoryView>() {

    override fun areItemsTheSame(oldItem: CategoryView, newItem: CategoryView) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: CategoryView, newItem: CategoryView) = oldItem.name == newItem.name
}
