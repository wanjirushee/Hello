package com.example.hello.models

 data class LoginRequest (
@SerializedName("email") var email: String,
@SerializedName("password") var password: String
 )
