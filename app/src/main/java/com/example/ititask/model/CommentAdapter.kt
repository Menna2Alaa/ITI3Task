package com.example.ititask.model

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.accessibility.AccessibilityManager.AccessibilityServicesStateChangeListener
import androidx.recyclerview.widget.RecyclerView
import com.example.ititask.Click
import com.example.ititask.databinding.TimelineBinding

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
        holder.binding.userId.text = "comment_id : ${commentList[position].postId} "
        holder.binding.id.text = "post id : ${commentList[position].id}"
        holder.binding.title.text = commentList[position].email
        holder.binding.body.text = commentList[position].body
        /* if(userList[position].avatar.isNotEmpty())
         {
             Picasso.get().load(userList[position].avatar).into(holder.binding.image)
         }*/
    }
}
