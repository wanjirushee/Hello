package com.example.hello

import android.content.Intent
import android.os.Bundle
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
