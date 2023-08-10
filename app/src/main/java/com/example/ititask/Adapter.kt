package com.example.ititask
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ititask.databinding.TimelineBinding
import com.example.ititask.model.User
import com.squareup.picasso.Picasso

class Adapter(private var userList:List<User>, private var listener : Click): RecyclerView.Adapter<Adapter.ViewHolder>() {
    inner class ViewHolder (val binding : TimelineBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val binding = TimelineBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.name.text="${userList[position].firstName} ${userList[position].lastName}"
        holder.binding.timePost.text= "${userList[position].id}"
        holder.binding.facebookPost.text=userList[position].email
        if(userList[position].avatar.isNotEmpty())
        {
            Picasso.get().load(userList[position].avatar).into(holder.binding.image)
        }
        holder.binding.detail.setOnClickListener {
            //listener.onItemClicked(userList[position],position)
        }
    }
}
