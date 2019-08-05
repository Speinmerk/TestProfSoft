package ru.speinmerk.testprofsoft.ui.common

import android.text.Editable
import android.text.TextWatcher

interface BaseTextWatcher : TextWatcher {
    override fun afterTextChanged(p0: Editable?) {
    }

    override fun beforeTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }
}