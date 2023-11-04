package com.atilsamancioglu.annotationmastery.model

import com.atilsamancioglu.annotationmastery.util.Summable
import com.atilsamancioglu.annotationmastery.util.VIPFields

data class Instructor(
    val name : String,
    val surname : String,
    @VIPFields val age : Int,
    @VIPFields val country : String,
    @Summable val rating1 : Int,
    @Summable val rating2 : Int,
    @Summable val rating3 : Int,
    @Summable val rating4 : Int,
    val rating5 : Int,
    @Summable val rating6 : Int
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
    fun sumRatings() {
        var ratingSum = 0
        this::class.java.declaredFields.forEach { field ->
            if (field.isAnnotationPresent(Summable::class.java)) {
                val valueOfCurrentRating = field.get(this) as? Int
                valueOfCurrentRating?.let { ratingSum += it }
            }
        }
        println(ratingSum)
    }
}
