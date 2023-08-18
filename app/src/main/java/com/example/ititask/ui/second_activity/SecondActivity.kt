package com.example.ititask.ui.second_activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ititask.R
import com.example.ititask.databinding.SecondActivityBinding
import com.example.ititask.model.CommentAdapter
import com.example.ititask.model.body.Post
import com.example.ititask.model.utils.Adapter
import com.example.ititask.model.utils.Click
import com.example.ititask.ui.third_activity.ThirdActivity
import com.example.ititask.ui.login.LoginActivity

class SecondActivity : AppCompatActivity() , Click {
    private lateinit var binding: SecondActivityBinding
    private lateinit var postAdapter: Adapter
    private lateinit var commentAdapter: CommentAdapter
    private lateinit var sharedPref: SharedPreferences
    private lateinit var viewModel : SecondViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = SecondViewModel()
        sharedPref= applicationContext.getSharedPreferences("UserPref", Context.MODE_PRIVATE)
        viewModel.postsData.observe(this){
            if (it.isSuccessful) {
                val posts = it.body()
                if (posts != null) {
                    postAdapter = Adapter(posts, this@SecondActivity)
                    binding.recyclerView.layoutManager = LinearLayoutManager(this@SecondActivity)
                    binding.recyclerView.adapter = postAdapter
                } else {
                    Toast.makeText(this@SecondActivity, "No posts found", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this@SecondActivity, "Error", Toast.LENGTH_LONG).show()
            }
        }

        viewModel.commentsData.observe(this){
            if(it.isSuccessful){
                val comments = it.body()
                if(comments!=null){
                    commentAdapter = CommentAdapter(comments)
                    binding.recyclerView.layoutManager = LinearLayoutManager(this@SecondActivity)
                    binding.recyclerView.adapter = commentAdapter
                }else {
                    Toast.makeText(this@SecondActivity, "No comments found", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this@SecondActivity, "Error", Toast.LENGTH_LONG).show()
            }
        }


        //Toast.makeText(this,"Done",Toast.LENGTH_LONG).show(

        //sharedPref = applicationContext.getSharedPreferences("UserPref", MODE_PRIVATE)

        //retrofit = RetrofitClient.getInstance("https://jsonplaceholder.typicode.com/")

        binding.postsBtn.setOnClickListener {
            viewModel.showPosts(binding.et.text.toString().toInt())

        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.second_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                val editor = sharedPref.edit()
                editor.remove("USERNAME")
                editor.remove("PASSWORD")
                editor.putBoolean("IS_LOGIN", false)
                editor.apply()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
                true
            }

            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onItemClicked(post: Post, position: Int) {
        viewModel.showComments(binding.et.text.toString().toInt())
        val intent = Intent(this@SecondActivity, ThirdActivity::class.java)
        intent.putExtra("post_id", post.id)
        startActivity(intent)

    }
}



