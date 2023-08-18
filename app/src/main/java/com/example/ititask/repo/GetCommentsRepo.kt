package com.example.ititask.repo

import com.example.ititask.model.body.Comments
import com.example.ititask.model.body.Post
import com.example.ititask.model.utils.RetrofitClient
import retrofit2.Response

class GetCommentsRepo {
    private val retrofit = RetrofitClient.getInstance("https://jsonplaceholder.typicode.com/")
    suspend fun getComments(postId : Int) : Response<ArrayList<Comments>> {
        return retrofit.getComments(postId)
    }
}
