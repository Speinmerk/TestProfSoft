package ru.speinmerk.testprofsoft.common.extensions

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel

val AndroidViewModel.context: Context get() = getApplication<Application>().applicationContext