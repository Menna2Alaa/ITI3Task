package com.example.ititask.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ititask.R
import com.example.ititask.databinding.ActivityMainBinding
import com.example.ititask.ui.second_activity.SecondActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //private lateinit var sharedPref: SharedPreferences
    private lateinit var viewModel: LoginViewModel

    private var sport = ""
    private var gender = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = LoginViewModel()
        //sharedPref= applicationContext.getSharedPreferences("UserPref", Context.MODE_PRIVATE)
        viewModel.loginData.observe(this) {
            Toast.makeText(this, "welcome ${it.body()?.firstname}", Toast.LENGTH_LONG).show()
        }

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
            binding.loading.visibility= View.VISIBLE
            viewModel.startLogin(binding.editText.text.toString() , binding.edit.text.toString())
            goToSecondScreen()
        }
    }
    private fun goToSecondScreen() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
        finish()
    }

    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    private fun showExitDialog() {
        val dialog = AlertDialog.Builder(this).setTitle("Exit Application")
            .setMessage("Are you sure you want to exit?").setPositiveButton("Yes") { _, _ ->
            finishAffinity()
        }
            .setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
        dialog.show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.go_to_second_activity -> {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("NAME", binding.editText.text.toString())
                intent.putExtra("SPORT", sport)
                intent.putExtra("GENDER", gender)
                startActivityForResult(intent, 120)
                return true
            }
            R.id.exit -> {
                showExitDialog()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }*/

        /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == 120) {
                Toast.makeText(
                    this,
                    data?.extras?.getString("LOGIN BY") ?: "error",
                    Toast.LENGTH_LONG
                ).show()
            }
        }*/
    }
/*binding.editText.setText(sharedPref.getString("USERNAME",""))
       binding.edit.setText(sharedPref.getString("PASSWORD",""))*/
//retrofit= RetrofitClient.getInstance("https://dummyjson.com/")