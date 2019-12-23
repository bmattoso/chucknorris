package br.com.chucknorris.category.presentation

import androidx.recyclerview.widget.RecyclerView
import br.com.chucknorris.category.databinding.ViewHolderCategoryBinding

class CategoryViewHolder(
    private val binding: ViewHolderCategoryBinding,
    private val listener: CategoryListener
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(categoryView: CategoryView) {
        binding.model = categoryView
        binding.listener = listener
    }
}
