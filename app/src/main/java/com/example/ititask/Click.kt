package com.example.ititask

import com.example.ititask.model.Post

interface Click {
    fun onItemClicked(post : Post, position : Int)
}
