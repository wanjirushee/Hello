package com.example.hello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hello.R
import kotlinx.android.synthetic.main.activity_courses.*
import layout.CoursesRecyclerViewAdapter
data class Activity(var course_id:Int,var course_name:String,var course_code:Int,var instructor:String,var description:String)
class Courses : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        rvCourses.layoutManager = LinearLayoutManager(baseContext)
        val coursesAdapter = CoursesRecyclerViewAdapter(listOf(
            Activity(0,"Javascript",2,"Purity","frameworks"),
            Activity(2,"Python",3,"Mwai","Django"),
            Activity(3,"Navigating",5,"Vero","Facing your fears"),
            Activity(7,"UI/UX dev",9, "Jeff","html/css"),
            Activity(5,"UI/UX design",8,"Nyandia","design"),
            Activity(9,"Kotlin",9,"John","Mobile dev"),
            Activity(3,"PD",8,"Rodgers","cv writing"),
            Activity(4,"Entreprenuership",7,"Kelly","Business Ideas"),
            Activity(7,"English",1,"Irine","Fluency"),
            Activity(6,"Swahili",5,"Lucy","Fluency")
            )
        )
        rvCourses.adapter = coursesAdapter
    }
}