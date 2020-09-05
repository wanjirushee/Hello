package com.example.hello.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.hello.R
import kotlinx.android.synthetic.main.activity_progressbar.*


val Nothing?.text: Any
    get() {
        TODO("Not yet implemented")
    }

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tvRegister = null
        tvRegister.setOnClickListener {
            val intent = Intent(baseContext, RegistrationActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            var email = etUserName.text.toString()
            var password = etPassword.text.toString()

            var error = false

            if (email.isBlank() || email.isEmpty()) {
                error = true
                etUserName.error = "Email is required"
            }

            if (password.isBlank() || password.isEmpty()) {
                error = true
                etPassword.error = "Password is required"
            }

            val requestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("email", email)
                .addFormDataPart("password", password)
                .build()

            if (!error) {
                pbLogin.visibility = View.VISIBLE
                loginUser(requestBody)
            }
        }
    }

        var btnLogin = null
        btnLogin.setOnClickListener {
            ->
            var etUserName = null
            var userName = etUserName.text.toString()

            var etPassword = null
            var password = etPassword.text.toString()
            Toast.makeText(
                baseContext, password, Toast
                    .LENGTH_SHORT
            ).show()
            startActivity(Intent(baseContext, CoursesActivity::class.java))
        }
    }

fun loginUser(requestBody: RequestBody) {
    val apiClient = ApiClient.buildService(ApiInterface::class.java)
    val loginCall = apiClient.loginStudent(requestBody)

    loginCall.enqueue(object : Callback<LoginResponse> {
        override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
            Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            pbLogin.visibility = View.GONE
        }

        override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
            if (response.isSuccessful) {
                pbLogin.visibility = View.GONE
                Toast.makeText(baseContext, response.body()?.message, Toast.LENGTH_LONG).show()

                var accessToken = response.body()?.accessToken
                val studentId = response.body()?.studentId
                var sharedPreferences =
                    PreferenceManager.getDefaultSharedPreferences(baseContext)
                var editor = sharedPreferences.edit()
                editor.putString("ACCESS_TOKEN_KEY", accessToken)
                editor.putString("STUDENT_ID_KEY", studentId)
                editor.apply()
                val intent = Intent(baseContext, CoursesActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                    .show()
            }
        }
    })
}
}

    val btnStartProgress = this.button1
    val progressBar:progressBar = this.progressBar1

    btnStartProgress.setOnClick{
        v ->

        this.@MainActivity.runOnUiThread(java.lang.Runner){
            ProgressBar.visibility = view.VISIBLE
        }

        try{
            var i = 0;
            while(i<Int.MAX_VALUE){
                i++
            }
        }catch(e:InterruptedException){
            e.printStackTrace()
        }
        this@MainActivity.runOnUiThread(java.lang.Runnable){
            progressBar.visibility = view.GONE
        })
    }

    private fun runOnUiThread(runnable: Runnable, function: () -> Unit) {

    }
    ).start()
 }
  }
}



class CoursesActivity {

}

fun Nothing?.setOnClickListener(function: () -> Unit) {
    TODO("Not yet implemented")
}
