package com.atilsamancioglu.annotationmastery.util

//@Retention(AnnotationRetention.RUNTIME) //default is runtime, use binary if it is smt like proguard @keep (do not obfuscate)
//@Repeatable //repeat the annotation for the same field, if it makes sense
@Target(AnnotationTarget.FIELD)
annotation class ValidEmail(val regex: String)

@Target(AnnotationTarget.FIELD)
annotation class ValidString(val regex: String)

@Target(AnnotationTarget.FUNCTION)
annotation class AuthTokenNeeded