package com.example.hello.activities

import android.os.Bundle
import android.telecom.Call
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.security.auth.callback.Callback
import android.content.Intent as Intent1
import com.example.hello.MainActivity as MainActivity


class RegistrationActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        var btnRegister = null
        btnRegister.setOnClickListener {
            var etFirstName = null
            var firstName = etFirstName.text.toString()
            val etLastName = null
            var lastName = etLastName.text.toString()
            val etEmail = null
            val email = etEmail.text.toString()
            val etPhoneNumber = null
            val phoneNumber = etPhoneNumber.text.toString()
            val etPassword = null
            val password = etPassword.text.toString()
            val etConfirmPassword = null
            val passwordConfirmation = etConfirmPassword.text.toString()

            var requestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("first_name", firstName)
                .addFormDataPart("last_name", lastName)
                .addFormDataPart("email", email)
                .addFormDataPart("phone_number", phoneNumber)
                .addFormDataPart("password", password)
                .build()

            registerUser(requestBody)
            Toast.makeText(baseContext, lastName, Toast.LENGTH_SHORT).show()
        }
    }


    class RegistrationActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_registration)

            var btnRegister = null
            btnRegister.setOnClickListener {
                var etFirstName = null
                var firstName = etFirstName.text.toString()
                val etLastName = null
                var lastName = etLastName.text.toString()
                val etEmail = null
                val email = etEmail.text.toString()
                val etPhoneNumber = null
                val phoneNumber = etPhoneNumber.text.toString()
                val etPassword = null
                val password = etPassword.text.toString()
                val etConfirmPassword = null
                val passwordConfirmation = etConfirmPassword.text.toString()

                var requestBody = MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("first_name", firstName)
                    .addFormDataPart("last_name", lastName)
                    .addFormDataPart("email", email)
                    .addFormDataPart("phone_number", phoneNumber)
                    .addFormDataPart("password", password)
                    .build()

                registerUser(requestBody)
                Toast.makeText(baseContext, lastName, Toast.LENGTH_SHORT).show()
            }
        }

        private fun registerUser(requestBody: MultipartBody) {
        }
        fun registerStudents(requestBody: RequestBody){
        var apiClient=ApiClient.buildService(ApiInterface::class.java)
            val registrationCall = apiClient.registerStudent(requestBody).also {
                it.enqueue(object : Callback<RegistrationResponse> {
                    override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                        Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(
                        call: Call<RegistrationResponse>,
                        response: Response<RegistrationResponse>
                    ) = if (response.isSuccessful){
                        Toast.makeText(baseContext,response.body()?.message,Toast.LENGTH_LONG).show()
                        startActivity(Intent1(baseContext, MainActivity::class.java))
                    } else {
                        Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                            .show()

                    }
                    else
                    {
                        var response = null
                        val show: Any = Toast.makeText(
                            baseContext,
                            response.errorBody().toString(),
                            Toast.LENGTH_LONG
                        ).show()
                    }

                }
            }
        }
    }