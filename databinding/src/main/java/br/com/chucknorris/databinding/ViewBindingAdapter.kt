package br.com.chucknorris.databinding

import android.view.View
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter

@BindingAdapter("setBackgroundColor")
fun View.updateBackgroundColor(@ColorRes color: Int) {
    setBackgroundColor(ContextCompat.getColor(context, color))
}

@BindingAdapter("present")
fun View.setPresent(isPresent: Boolean) {
    visibility = if (isPresent) {
        View.VISIBLE
    } else {
        View.GONE
    }
}

@BindingAdapter("android:text")
fun TextView.updateText(@StringRes textRes: Int) {
    if (textRes != 0) {
        text = context.resources.getString(textRes)
    }
}
