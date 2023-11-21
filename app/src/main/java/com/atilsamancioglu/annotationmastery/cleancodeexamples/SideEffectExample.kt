package com.atilsamancioglu.annotationmastery.cleancodeexamples

//side effect wrong

var globalCounter = 0

fun incrementCounter(inc: Int) {
    globalCounter += inc // Side effect: Modifying a global variable
}

fun main() {
    incrementCounter(5)
    println("Global Counter: $globalCounter") // Global Counter: 5
    incrementCounter(3)
    println("Global Counter: $globalCounter") // Global Counter: 8
}

//side effect right

fun incrementCounter(currentValue: Int, inc: Int): Int {
    return currentValue + inc // No side effects: Doesn't modify any external state
}

fun mainCorrect() {
    val result1 = incrementCounter(0, 5)
    println("Result 1: $result1") // Result 1: 5

    val result2 = incrementCounter(result1, 3)
    println("Result 2: $result2") // Result 2: 8
}