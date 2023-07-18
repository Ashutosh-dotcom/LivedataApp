package com.example.livedataapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.livedataapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainActivityViewModelFactory



    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main)

        viewModelFactory = MainActivityViewModelFactory(200)
        viewModel =ViewModelProvider(this,viewModelFactory)
            .get(MainActivityViewModel::class.java)


            viewModel.totalSum.observe(
                this,
                Observer {
                   binding.resultTXT.text=it.toString()
                }
            )
        binding.btn.setOnClickListener {
            viewModel.sumUp(binding.editText.text.toString().toInt())
        }

    }
}