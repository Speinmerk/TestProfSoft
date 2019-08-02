package ru.speinmerk.testprofsoft.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import ru.speinmerk.testprofsoft.vm.MainViewModel
import ru.speinmerk.testprofsoft.R

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
    }
}
