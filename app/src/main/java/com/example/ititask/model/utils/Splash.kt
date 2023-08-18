package com.example.ititask.model.utils

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.ititask.databinding.SplashBinding
import com.example.ititask.ui.login.LoginActivity
import com.example.ititask.ui.second_activity.SecondActivity

class Splash:AppCompatActivity() {
    private lateinit var binding: SplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashBinding.inflate(layoutInflater)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(binding.root)

        val sharedPref = applicationContext.getSharedPreferences("UserPref", MODE_PRIVATE)
        val isLogged = sharedPref.getBoolean("IS_LOGIN",false)

        Handler().postDelayed(Runnable{
            if(isLogged)
            {
                startActivity(Intent(this, SecondActivity::class.java))
            }
            else{
                startActivity(Intent(this, LoginActivity::class.java))
            }
            finish()
        },3000)
    }
}


