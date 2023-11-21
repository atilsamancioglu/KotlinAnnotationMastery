package com.atilsamancioglu.annotationmastery.cleancodeexamples

class Dog {
    val trick = Trick()
}
class Trick {
    fun executeTrick() {
        println("trick")
    }
}
class Animal(
    dog : Dog
) {
    init {
        dog.trick.executeTrick()
    }
}

