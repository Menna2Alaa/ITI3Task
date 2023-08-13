package com.example.ititask
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ititask.databinding.TimelineBinding
import com.example.ititask.model.Post

class Adapter(private var postsList:List<Post> ,private var listener: Click): RecyclerView.Adapter<Adapter.ViewHolder>() {
    inner class ViewHolder (val binding : TimelineBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val binding = TimelineBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return postsList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.userId.text="user id : ${postsList[position].userId} "
        holder.binding.id.text= "post id : ${postsList[position].id}"
        holder.binding.title.text=postsList[position].title
        holder.binding.body.text=postsList[position].body
       /* if(userList[position].avatar.isNotEmpty())
        {
            Picasso.get().load(userList[position].avatar).into(holder.binding.image)
        }*/
        holder.binding.detail.setOnClickListener {
            listener.onItemClicked(postsList[position], position)
        }
    }
}
