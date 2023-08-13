package com.example.ititask

//import android.net.Uri
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.ititask.databinding.ActivityMainBinding
import com.example.ititask.model.LoginBody
import com.example.ititask.model.utils.ApiInterface
import com.example.ititask.model.utils.RetrofitClient
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPref :SharedPreferences
    private lateinit var retrofit : ApiInterface

    private var sport = ""
    private var gender = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref= applicationContext.getSharedPreferences("UserPref", Context.MODE_PRIVATE)
        /*binding.editText.setText(sharedPref.getString("USERNAME",""))
        binding.edit.setText(sharedPref.getString("PASSWORD",""))*/

        retrofit=RetrofitClient.getInstance("https://dummyjson.com/")


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
            lifecycleScope.launchWhenCreated {
                try {
                    val response = retrofit.login(
                        LoginBody(
                            binding.editText.text.toString(),
                            binding.edit.text.toString()
                        )
                    )
                    if (response.isSuccessful) {
                        goToSecondScreen()
                    } else {
                        val json = JSONObject(response.errorBody()?.string())
                        Toast.makeText(this@MainActivity,json.getString("message") , Toast.LENGTH_LONG).show()
                    }
                }catch (e: Exception) {
                    e.printStackTrace()
                    Toast.makeText(
                        this@MainActivity,
                        "An error occurred: ${e.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
    private fun goToSecondScreen()
    {
        val editor = sharedPref.edit()
        editor.putString("USERNAME",binding.editText.text.toString())
        editor.putString("PASSWORD",binding.edit.text.toString())
        editor.putBoolean("IS_LOGIN",true)
        editor.commit()
        val intent = Intent(this,SecondActivity::class.java)
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
