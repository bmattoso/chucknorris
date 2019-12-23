package br.com.chucknorris.databinding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

@BindingAdapter("adapter")
fun RecyclerView.setListAdapter(adapter: ListAdapter<*, *>) {
    this.adapter = adapter
}

@BindingAdapter("data")
fun RecyclerView.setData(data: List<*>?) {
    if (adapter is ListAdapter<*, ViewHolder>) {
        (adapter as ListAdapter<Any, ViewHolder>).submitList(data)
    }
}
