package com.example.ititask.model

import com.google.gson.annotations.SerializedName

data class Support(
    @SerializedName("url")
    var url : String ,
    @SerializedName("text")
    var text : String
) {
}