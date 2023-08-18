package com.example.ititask.model.response
import com.example.ititask.model.body.Support
import com.example.ititask.model.body.Post
import com.google.gson.annotations.SerializedName

data class ResponseUsers(
    @SerializedName("page")
    var page : Int,
    @SerializedName("per_page")
    var perPage : Int,
    @SerializedName("total")
    var total : Int,
    @SerializedName("total_pages")
    var totalPages : Int,
    @SerializedName("data")
    var data : List<Post>,
    @SerializedName("support")
    var support : Support
) {
}