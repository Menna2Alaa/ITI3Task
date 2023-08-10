package com.example.ititask.model.utils

import com.example.ititask.model.ResponseUsers
import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("api/users")
    suspend fun getUsers() : Response<ResponseUsers>
}