package com.example.ititask.model

import com.google.gson.annotations.SerializedName

data class LoginBody (
    @SerializedName("username")
    var username : String,
    @SerializedName("password")
    var password : String
)