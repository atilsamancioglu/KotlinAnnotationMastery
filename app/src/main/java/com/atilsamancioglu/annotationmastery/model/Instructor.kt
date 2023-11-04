package com.atilsamancioglu.annotationmastery.model

import com.atilsamancioglu.annotationmastery.util.VIPFields

data class Instructor(
    val name : String,
    val surname : String,
    @VIPFields val age : Int,
    @VIPFields val country : String
) {
    fun printAllVars() {
        println(this.toString())
    }
    fun printVIPVars() {
        this::class.java.declaredFields.forEach { field ->
            if (field.isAnnotationPresent(VIPFields::class.java)) {
                println("${field.name} ${field.get(this)}")
            }
        }
    }
}
