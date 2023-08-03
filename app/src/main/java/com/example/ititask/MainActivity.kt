package com.example.ititask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ititask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var sport = ""
    private var gender = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.football.setOnCheckedChangeListener { _, b ->
            if (b) {
                sport = "your favorite sport is football"
            } else if (binding.tennis.isChecked) {
                sport = "your favorite sport is tennis"
            } else if (binding.basketball.isChecked) {
                sport = "your favorite sport is basketball"
            }
            binding.male.setOnCheckedChangeListener { _, b ->
                gender = if (b) {
                    "you are a male"
                } else {
                    "you are a female"
                }
            }
            println(gender)
            binding.login.setOnClickListener {
                Toast.makeText(this, "welcome ${binding.editText.text},$sport ,$gender", Toast.LENGTH_LONG).show()
            }

        }
    }
}