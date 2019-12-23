package br.com.chucknorris.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load

@BindingAdapter("setImageRes")
fun setImageRes(imageView: ImageView, imageUrl: String?) {
    imageView.load(imageUrl)
}
