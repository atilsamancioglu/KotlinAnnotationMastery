package com.atilsamancioglu.annotationmastery.cleancodeexamples

class Dog {
    private val trick = Trick()

    fun doTrick() {
        trick.executeTrick()
    }
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
        dog.doTrick()
    }
}


