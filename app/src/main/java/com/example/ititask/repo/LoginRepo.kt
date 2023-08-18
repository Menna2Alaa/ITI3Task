package com.example.ititask.repo

import android.content.Context
import android.content.SharedPreferences
import com.example.ititask.model.body.LoginBody
import com.example.ititask.model.response.UserResponse
import com.example.ititask.model.utils.RetrofitClient
import retrofit2.Response

class LoginRepo {

    private val retrofit = RetrofitClient.getInstance("https://dummyjson.com/")
    suspend fun login(username : String , password : String) : Response<UserResponse>{
        return retrofit.login(LoginBody(username, password))
    }

}
