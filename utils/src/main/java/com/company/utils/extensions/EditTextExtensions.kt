package com.company.utils.extensions

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

fun EditText.observeTextChanges(): Flow<String> = callbackFlow<String> {
    val listener = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            s?.toString()?.let { offer(it) }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) { }
    }

    addTextChangedListener(listener)
    awaitClose { removeTextChangedListener(listener) }
}