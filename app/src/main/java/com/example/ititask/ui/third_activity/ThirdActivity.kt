package com.example.ititask.ui.third_activity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ititask.databinding.ThirdActivityBinding
import com.example.ititask.model.CommentAdapter
import com.example.ititask.ui.second_activity.SecondViewModel

class ThirdActivity : AppCompatActivity(){
    private lateinit var binding: ThirdActivityBinding
    private lateinit var viewModel : SecondViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ThirdActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val comment = intent.extras?.getInt("post_id", 0)
        viewModel = SecondViewModel()
        viewModel.showComments(comment.toString().toInt())
        viewModel.commentsData.observe(this) {
            if (it.isSuccessful) {
                val commentAdapter = CommentAdapter(it.body()?: listOf())
                binding.recyclerView1.layoutManager = LinearLayoutManager(this@ThirdActivity)
                binding.recyclerView1.adapter = commentAdapter
            } else {
                Toast.makeText(this@ThirdActivity, "error", Toast.LENGTH_LONG).show()
            }
        }
    }
}

