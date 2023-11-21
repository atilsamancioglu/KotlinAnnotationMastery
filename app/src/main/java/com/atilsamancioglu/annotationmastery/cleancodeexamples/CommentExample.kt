package com.atilsamancioglu.annotationmastery.cleancodeexamples

import com.atilsamancioglu.annotationmastery.model.Student

fun main() {

    //First Example
    val students = arrayListOf<Student>(
        Student("a","a","a@a.com"),
        Student("b","b","b@b.com"),
        Student("c","c","c@c.com"),
        Student("d","d","d@d.com"),
    )
    fun findStudentFromSurname(surname: String) : Student? {
        // loops through all students and checks if given surname matches
        for (student in students) {
            if (student.surname == surname) {
                return student
            }
        }
        return null
    }

}


