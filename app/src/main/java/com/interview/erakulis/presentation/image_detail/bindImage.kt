package com.interview.erakulis.presentation.image_detail

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, url: String?) {
    url?.let {
        imageView.load(it) {
            placeholder(android.R.drawable.progress_indeterminate_horizontal) // You can set a placeholder image
            error(android.R.drawable.stat_notify_error) // You can set an error image
        }
    }
}
