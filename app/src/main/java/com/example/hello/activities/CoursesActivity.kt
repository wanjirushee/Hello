package com.example.hello.activities

import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hello.models.Course
import retrofit2.Call
import retrofit2.Callback
import okhttp3.Response as Okhttp3Response

class CoursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        fetchCourses()
    }

    fun fetchCourses() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
        val accessToken = sharedPreferences.getString("ACCESS_TOKEN_KEY", "")

        val apiClient = ApiClient.buildService(ApiInterface::class.java)
        val coursesCall = apiClient.getCourses("Bearer " + accessToken)
        val enqueue: Any = coursesCall.enqueue(object : Callback<CoursesResponse> {


            override fun onFailure(call: Call<CoursesResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<CoursesResponse>,
                response: Okhttp3Response<CoursesResponse>
            ) = if (response.isSuccessful) {
                var courseList = response.body()?.courses as List<Course>
                var coursesAdapter = CoursesAdapter(courseList)
                rvCourses.layoutManager = LinearLayoutManager(baseContext)
                rvCourses.adapter = coursesAdapter
            } else {
                Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                    .show()
            }

            private fun CoursesAdapter(courseList: List<Course>): RecyclerView.Adapter<RecyclerView.ViewHolder>? {

            }
        })
    }
}

fun fetchCoursesFromDatabase(){
    Thread{
        val database
        val courses = 
            database.courseDao().getAllCourses()

        runOnUiThread {
            displayCourses(courses)
        }
    }.start()
}

fun displayCourses(courses: List<Course>){
    var coursesAdapter = CoursesAdapter(courses, this)
    rvCourses.layoutManager = LinearLayoutManager(baseContext)
    rvCourses.adapter = coursesAdapter
}

override fun onItemClick(course: Course) {
    //obtain student id from shared preferences
    //courseId = course.courseId
    //make a post request https://github.com/owuor91/registration-api
}
}