package com.example.hello.api

object ApiClient {
    var client = OkHttpClient.Builder().build()

    var retrofit = Retrofit.Builder()
        .baseUrl("https://courses-service.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}