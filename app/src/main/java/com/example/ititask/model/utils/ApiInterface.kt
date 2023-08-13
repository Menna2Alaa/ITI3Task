package com.example.ititask.model.utils

import com.example.ititask.model.Comments
import com.example.ititask.model.LoginBody
import com.example.ititask.model.Post
import com.example.ititask.model.ResponseUsers
import com.example.ititask.model.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET("posts")
    suspend fun getPosts() : Response<ArrayList<Post>>
    @GET("posts")
    suspend fun getPostsByUser(@Query("userId") userId : Int) : Response<ArrayList<Post>>
    @GET("posts/{postId}/comments")
    suspend fun getComments(@Path("postId") postId : Int) : Response<ArrayList<Comments>>

    @POST("auth/login")
    suspend fun login(@Body body: LoginBody) : Response<UserResponse>
}
