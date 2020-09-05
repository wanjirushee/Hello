package com.example.hello.database


@Dao
interface CoursesDao {
   @Insert (onConflict = onConflictStrategy.REPLACE)
    fun insertCourse(course:Course)

    @Query(value :"SELECT* FROM courses")
    fun getAllCourses()List<Courses>

}