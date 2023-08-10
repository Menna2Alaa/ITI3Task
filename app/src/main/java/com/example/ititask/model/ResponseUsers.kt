package com.example.ititask.model

import androidx.appcompat.app.AppCompatActivity
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
    var data : List<User>,
    @SerializedName("support")
    var support : Support
) {
}