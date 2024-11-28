package com.interview.erakulis.presentation.image_detail

import android.view.View
import androidx.databinding.BindingAdapter
import com.interview.erakulis.domain.ImageDetailState

@BindingAdapter("bindVisibility")
fun bindVisibility(view: View, state: ImageDetailState?) {
    when (state) {
        is ImageDetailState.Loading -> {
            view.visibility = View.VISIBLE
        }
        is ImageDetailState.Success -> {
            view.visibility = View.VISIBLE
        }
        is ImageDetailState.Error -> {
            view.visibility = View.VISIBLE
        }
        else -> {
            view.visibility = View.GONE
        }
    }
}
