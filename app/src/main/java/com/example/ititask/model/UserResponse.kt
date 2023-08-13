package com.example.ititask.model

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("id")
    var id : Int,
    @SerializedName("username")
    var username : String,
    @SerializedName("email")
    var email : String,
    @SerializedName("firstname")
    var firstname : String,
    @SerializedName("lastname")
    var lastname : String,
    @SerializedName("gender")
    var gender : String,
    @SerializedName("image")
    var image : String,
    @SerializedName("token")
     var token : String
)