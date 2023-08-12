package com.example.ititask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ititask.databinding.ThirdActivityBinding
import com.example.ititask.model.Comments

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ThirdActivityBinding
       override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ThirdActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.postId.text = "post_id : ${intent.extras?.getInt("post_id", 0).toString()}"
        binding.commentId.text = "comment_id : ${intent.extras?.getInt("comment_id", 0).toString()}"
        binding.nameId.text = "name : ${intent.extras?.getString("name", "")}"
        binding.emailId.text = "email : ${intent.extras?.getString("email", "")}"
        binding.comment.text = "body_comment : ${intent.extras?.getString("body", "")}"

        /*Toast.makeText(this, intent?.extras?.getString("USERNAME") ?: "error", Toast.LENGTH_LONG).show()
        Toast.makeText(this, intent?.extras?.getString("POST") ?: "error", Toast.LENGTH_LONG).show()*/
    }
}
