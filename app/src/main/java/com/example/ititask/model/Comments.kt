package com.example.ititask.model
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Comments (
    @SerializedName("id")
    var id : Int,
    @SerializedName("postId")
    var postId : Int,
    @SerializedName("name")
    var name : String,
    @SerializedName("email")
    var email : String,
    @SerializedName("body")
    var body : String
)

