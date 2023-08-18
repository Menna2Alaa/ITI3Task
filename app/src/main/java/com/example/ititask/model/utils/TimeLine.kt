package com.example.ititask.model.utils

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ititask.databinding.TimelineBinding

data class TimeLine(var userName : String, var time : String, var post : String, var imageurl : String): AppCompatActivity() {
    private lateinit var binding: TimelineBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = TimelineBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}

