package com.example.ititask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ititask.databinding.SecondActivityBinding
import com.example.ititask.databinding.TimelineBinding
import com.example.ititask.databinding.UserBinding

data class Timeline(var userName : String , var time : String , var post : String ): AppCompatActivity() {
    private lateinit var binding: TimelineBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = TimelineBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
