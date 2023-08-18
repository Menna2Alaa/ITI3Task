package com.example.ititask.repo

import com.example.ititask.model.body.Post
import com.example.ititask.model.utils.RetrofitClient
import retrofit2.Response

class GetPostsRepo {
    val retrofit = RetrofitClient.getInstance("https://jsonplaceholder.typicode.com/")
    suspend fun getPosts(userId : Int) : Response<ArrayList<Post>> {
        return retrofit.getPostsByUser(userId)
    }
}
