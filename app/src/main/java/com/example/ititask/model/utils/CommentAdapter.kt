package com.example.ititask.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ititask.databinding.TimelineBinding
import com.example.ititask.model.body.Comments

class CommentAdapter(private var commentList:List<Comments> ): RecyclerView.Adapter<CommentAdapter.ViewHolder>() {
    inner class ViewHolder (val binding : TimelineBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TimelineBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return commentList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.userId.text = "comment_id : ${commentList[position].id} "
        holder.binding.id.text = "post id : ${commentList[position].postId}"
        holder.binding.title.text = "comment writer : ${commentList[position].name}"
        holder.binding.body.text = "body of comment :${commentList[position].body}"
        holder.binding.detail.visibility=View.GONE

    }
}
