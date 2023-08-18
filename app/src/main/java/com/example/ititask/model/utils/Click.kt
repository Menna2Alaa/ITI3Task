package com.example.ititask.model.utils

import com.example.ititask.model.body.Post


interface Click {
    fun onItemClicked(post: Post, position: Int)
}
