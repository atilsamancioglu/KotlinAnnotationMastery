package com.atilsamancioglu.annotationmastery.model

import com.atilsamancioglu.annotationmastery.util.Constants
import com.atilsamancioglu.annotationmastery.util.ValidEmail
import com.atilsamancioglu.annotationmastery.util.ValidString

//@ValidRegex("") //we cannot use it here since it is targeted to field
data class Student(
    @ValidString(Constants.VALID_STRING_REGEX_STRING) val name : String,
    @ValidString(Constants.VALID_STRING_REGEX_STRING) val surname : String,
    @ValidEmail(Constants.VALID_EMAIL_REGEX_STRING) val email : String
) {
    init {
        val fields = this::class.java.declaredFields
        fields.forEach { field ->
            field.annotations.forEach {
                if(field.isAnnotationPresent(ValidEmail::class.java)) {
                    val regex = field.getAnnotation(ValidEmail::class.java)?.regex
                    if(regex?.toRegex()?.matches(email) != true) {
                        throw IllegalArgumentException("email is not valid!")
                    }
                } else if (field.isAnnotationPresent(ValidString::class.java)) {
                    val regex = field.getAnnotation(ValidString::class.java)?.regex
                    val currentValue = field.get(this) as? CharSequence //value of current parameter
                    currentValue?.let {
                        if(regex?.toRegex()?.matches(it) != true) {
                            throw IllegalArgumentException("${field.name} is not valid!")
                        }
                    }
                }
            }
        }
    }
}



