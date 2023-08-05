package com.example.ititask

//import android.net.Uri
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
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
        }
        println(sport)
        binding.male.setOnCheckedChangeListener { _, b ->
            gender = if (b) {
                "you are a male"
            } else {
                "you are a female"
            }
        }
        println(gender)
        binding.login.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("NAME",binding.editText.text.toString())
            intent.putExtra("SPORT",sport)
            intent.putExtra("GENDER",gender)
            startActivityForResult(intent,120)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==120)
        {
            Toast.makeText(this,data?.extras?.getString("LOGIN BY")?:"error",Toast.LENGTH_LONG).show()
        }
    }
}
