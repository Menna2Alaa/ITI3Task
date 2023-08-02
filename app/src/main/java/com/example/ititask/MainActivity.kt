package com.example.ititask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ititask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.login.setOnClickListener {
            println(binding.editText.text)
            println(binding.edit.text)
        }

    }
}