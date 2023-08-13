package com.example.ititask
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ititask.databinding.ThirdActivityBinding
import com.example.ititask.model.CommentAdapter
import com.example.ititask.model.Comments
import com.example.ititask.model.Post
import com.example.ititask.model.utils.RetrofitClient


class ThirdActivity : AppCompatActivity(){
    private lateinit var binding: ThirdActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ThirdActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val comment = intent.extras?.getInt("post_id", 0)
        var retrofit = RetrofitClient.getInstance("https://jsonplaceholder.typicode.com/")

        lifecycleScope.launchWhenCreated {
            var response = retrofit.getComments(comment.toString().toInt())

            try {
                if (response.isSuccessful) {
                    var commentAdapter = CommentAdapter(response.body()?: listOf())
                    binding.recyclerView1.layoutManager = LinearLayoutManager(this@ThirdActivity)
                    binding.recyclerView1.adapter = commentAdapter
                    Toast.makeText(
                        this@ThirdActivity,
                        response.body()?.get(0)?.body ?: "no data",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(this@ThirdActivity, "error", Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(
                    this@ThirdActivity,
                    "An error occurred: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}

        /*val listItemCount = intent.extras?.getSerializable("list") as? MutableList<Comments>
        listItemCount?.forEach { _ ->
            binding.postId.text = "post_id : ${intent.extras?.getInt("post_id", 0).toString()}"
            binding.commentId.text = "comment_id : ${intent.extras?.getInt("comment_id", 0).toString()}"
            binding.nameId.text = "name : ${intent.extras?.getString("name", "")}"
            binding.emailId.text = "email : ${intent.extras?.getString("email", "")}"
            binding.comment.text = "body_comment : ${intent.extras?.getString("body", "")}"
        }*/

        /*Toast.makeText(this, intent?.extras?.getString("USERNAME") ?: "error", Toast.LENGTH_LONG).show()
          Toast.makeText(this, intent?.extras?.getString("POST") ?: "error", Toast.LENGTH_LONG).show()*/

