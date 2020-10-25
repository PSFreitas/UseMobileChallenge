package com.usemobile

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import com.usemobile.valuableobject.Status

class BindingAdapters {

    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: ImageView, url: String?) {
            if (!url.isNullOrEmpty()) {
                Picasso.get().load(
                    url
                ).placeholder(
                    R.drawable.ic_launcher_background
                ).into(
                    imageView
                )
            }

        }

        @JvmStatic
        @BindingAdapter("progressBarVisibleUnless")
        fun progressBarVisibleUnless(progressBar: ProgressBar, status: Status?) {
            if (status == Status.LOADING) {
                progressBar.visibility = View.VISIBLE
            } else {
                progressBar.visibility = View.GONE
            }
        }

        @JvmStatic
        @BindingAdapter("goneUnless")
        fun goneUnless(view: View, status: Status?) {
            if (status == Status.SUCCESS) {
                view.visibility = View.VISIBLE
            } else {
                view.visibility = View.GONE
            }
        }

    }
}