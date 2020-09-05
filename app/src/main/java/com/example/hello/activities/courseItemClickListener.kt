package com.example.hello.activities

import com.example.hello.models.Course

interface courseItemClickListener {
    fun onItemClick(course: Course)
}