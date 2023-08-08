package com.example.ititask
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ititask.databinding.TimelineBinding
import com.squareup.picasso.Picasso

class Adapter(private var timeline:ArrayList<Timeline>, private var listener : Click): RecyclerView.Adapter<Adapter.ViewHolder>() {
    inner class ViewHolder (val binding : TimelineBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val binding = TimelineBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return timeline.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.name.text=timeline[position].userName
        holder.binding.timePost.text=timeline[position].time
        holder.binding.facebookPost.text=timeline[position].post
        if(timeline[position].imageurl.isNotEmpty())
        {
            Picasso.get().load(timeline[position].imageurl).into(holder.binding.image)
        }
        holder.binding.detail.setOnClickListener {
            listener.onItemClicked(timeline[position],position)
        }
    }
}
