package com.company.utils.extensions

import android.view.View
import com.company.SafeOnClickListener

fun View.onClick(safe: Boolean = true, action: (View) -> Unit) = setOnClickListener(
    SafeOnClickListener(safe, action)
)

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.visibleIf(condition: Boolean, gone: Boolean = true) = when {
    condition -> visible()
    else -> if (gone) gone() else invisible()
}