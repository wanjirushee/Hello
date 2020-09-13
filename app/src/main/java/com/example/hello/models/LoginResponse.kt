package com.example.hello.models

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("access_token") var accessToken: String,
    @SerializedName("message") var message: String
    @serializedName("student_id") var studentId:String
)