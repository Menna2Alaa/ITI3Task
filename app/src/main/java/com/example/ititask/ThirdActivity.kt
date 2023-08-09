package com.example.ititask

import android.icu.text.Transliterator.Position
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ititask.databinding.ThirdActivityBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ThirdActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ThirdActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

       Toast.makeText(this, intent?.extras?.getString("USERNAME") ?: "error", Toast.LENGTH_LONG).show()
        Toast.makeText(this, intent?.extras?.getString("POST") ?: "error", Toast.LENGTH_LONG).show()
    }
}
