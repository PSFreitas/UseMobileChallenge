package com.usemobile

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

class BindingAdapters {

    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: ImageView, url: String) {
            Picasso.get().load(
                url
            ).placeholder(
                R.drawable.ic_launcher_background
            ).into(
                imageView
            )
        }
    }
}