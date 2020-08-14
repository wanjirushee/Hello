package com.example.hello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*




class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    tvRegister.setOnClickListener {
      val intent = Intent(baseContext, RegistrationActivity::class.java)
      startActivity(intent)
    }

    btnLogin.setOnClickListener {
      var userName = etUserName.text.toString()
      var password = etPassword.text.toString()
      Toast.makeText(baseContext, password, Toast.LENGTH_SHORT).show()
      startActivity(Intent(baseContext, CoursesActivity::class.java))
    }
  }
}
