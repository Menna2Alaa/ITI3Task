package com.example.ititask

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ititask.databinding.SecondActivityBinding
import com.example.ititask.model.utils.ApiInterface
import com.example.ititask.model.utils.RetrofitClient

class SecondActivity : AppCompatActivity() , Click{
    private lateinit var binding: SecondActivityBinding
    private lateinit var userAdapter : Adapter
    private lateinit var sharedPref : SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref=applicationContext.getSharedPreferences("UserPref", MODE_PRIVATE)
        binding.tv.text="welcome ${sharedPref.getString("USERNAME","")}"

        /*Toast.makeText(this,intent?.extras?.getString("NAME")?:"error",Toast.LENGTH_LONG).show()
        Toast.makeText(this,intent?.extras?.getString("SPORT")?:"error",Toast.LENGTH_LONG).show()
        Toast.makeText(this,intent?.extras?.getString("GENDER")?:"error",Toast.LENGTH_LONG).show()*/


        val time_line = arrayListOf(TimeLine("Omar","45m","Sometimes I feel so - I don’t know - lonely. The kind of helpless feeling when everything you’re used to has been ripped away. Like there’s no more gravity, and I’m left to drift in outer space with no idea where I’m going","https://images.unsplash.com/photo-1622932720890-15cdc9364a55?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8c2VhJTIwYmVhY2h8ZW58MHx8MHx8fDA%3D&w=1000&q=80")
            ,TimeLine("Menna","22 h","Mental Health is a silent battle","https://cdn.theatlantic.com/thumbor/B7U27JF25tScMZkCe5Pl9EqXjao=/0x131:2555x1568/960x540/media/img/mt/2017/06/shutterstock_319985324/original.jpg"))



        var retrofit = RetrofitClient.getInstance().create(ApiInterface::class.java)
        lifecycleScope.launchWhenCreated {
            val response = retrofit.getUsers()
            if(response.isSuccessful){

                userAdapter=Adapter(response.body()?.data?: listOf(),this@SecondActivity)
                binding.recyclerView.layoutManager=LinearLayoutManager(this@SecondActivity)
                binding.recyclerView.adapter=userAdapter
                Toast.makeText(this@SecondActivity , response.body()?.data?.get(0)?.firstName?:"no data" , Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this@SecondActivity , "error" , Toast.LENGTH_LONG).show()
            }
        }

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
     override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         menuInflater.inflate(R.menu.second_menu, menu)
         return true
     }

     override fun onOptionsItemSelected(item: MenuItem): Boolean {
         return when(item.itemId){
             R.id.logout->{
                 val editor = sharedPref.edit()
                 editor.remove("USERNAME")
                 editor.remove("PASSWORD")
                 editor.putBoolean("IS_LOGIN",false)
                 editor.commit()
                 startActivity(Intent(this,MainActivity::class.java))
                 finish()
                 true
             }
             else->
             {
                 super.onOptionsItemSelected(item)
             }
         }
     }


     override fun onItemClicked(post: TimeLine, position: Int) {
         val intent = Intent(this,ThirdActivity::class.java)
         intent.putExtra("USERNAME",post.userName)
         intent.putExtra("POST",post.post)
         startActivity(intent)
         //Toast.makeText(this, "item num $position username :${post.userName}", Toast.LENGTH_LONG).show()
     }

}


