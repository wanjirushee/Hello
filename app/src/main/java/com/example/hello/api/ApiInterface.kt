package com.example.hello.api

import android.telecom.Call
import com.example.hello.models.CoursesResponse
import com.example.hello.models.LoginResponse

interface ApiInterface {
    @POST("register")
    fun registerStudent(@Body requestBody: RequestBody): Call<RegistrationResponse>

    @POST("login")
    fun loginStudent(@Body requestBody: RequestBody): Call<LoginResponse>

    @GET("courses")
    fun getCourses(@Header("Authorization") accessToken: String): Call<CoursesResponse>
}