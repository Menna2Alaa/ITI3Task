package com.example.ititask

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ititask.databinding.SecondActivityBinding

 class SecondActivity : AppCompatActivity() {
    private lateinit var binding: SecondActivityBinding
    private lateinit var timelineAdapter : Adapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(this,intent?.extras?.getString("NAME")?:"error",Toast.LENGTH_LONG).show()
        Toast.makeText(this,intent?.extras?.getString("SPORT")?:"error",Toast.LENGTH_LONG).show()
        Toast.makeText(this,intent?.extras?.getString("GENDER")?:"error",Toast.LENGTH_LONG).show()


        val time_line = arrayListOf(Timeline("Omar","45m","Sometimes I feel so - I don’t know - lonely. The kind of helpless feeling when everything you’re used to has been ripped away. Like there’s no more gravity, and I’m left to drift in outer space with no idea where I’m going")
            ,Timeline("Heba","30m","hello i am a programmer"))
        timelineAdapter=Adapter(time_line)
        binding.recyclerView.adapter=timelineAdapter


        /*binding.loginWith.setOnClickListener {
            val loginBy = if(binding.google.isChecked)
            {
                "login with google"
            }
            else{
                "login with facebook"
            }
            val intent = Intent()
            intent.putExtra("LOGIN BY",loginBy)
            setResult(88,intent)
            finish()
        }*/
    }
}


