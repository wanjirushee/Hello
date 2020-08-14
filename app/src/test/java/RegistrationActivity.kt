import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.hello.R
import okhttp3.*
import okhttp3.Call as Call1


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


    fun registerUser(requestBody: RequestBody) {
        var apiClient = ApiClient.buildService(ApiInterface::class.java)
        apiClient.registerStudent(requestBody).also {
            it.enqueue(object : Callback<RegistrationResponse> {
                fun onFailure(call: Call1<RegistrationResponse>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }
    
                fun onResponse(
                    call: Call1<RegistrationResponse>,
                    response: Response<RegistrationResponse>
                ) {
                    if (response.isSuccessful) {
                        Toast.makeText(baseContext, response.body()?.message, Toast.LENGTH_LONG).show()
                        startActivity(Intent(baseContext, MainActivity::class.java))
                    } else {
                        Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                            .show()
                    }
                }
            })
        }
    }
}

private fun <T> Call1<T>.enqueue(any: Any) {

}






