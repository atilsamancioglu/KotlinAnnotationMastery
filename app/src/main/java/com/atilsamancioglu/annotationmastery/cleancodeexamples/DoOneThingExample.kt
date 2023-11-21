package com.atilsamancioglu.annotationmastery.cleancodeexamples

//wrong way
fun processNumbers(numbers: List<Int>) {
    val sum = numbers.sum()
    val max = numbers.maxOrNull() ?: 0

    println("Sum: $sum")
    println("Max: $max")
}

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    processNumbers(numbers)
}

//right way

fun sumNumbers(numbers: List<Int>): Int {
    return numbers.sum()
}

fun findMax(numbers: List<Int>): Int {
    return numbers.maxOrNull() ?: 0
}

fun displayResults(sum: Int, max: Int) {
    println("Sum: $sum")
    println("Max: $max")
}

fun mainRight() {
    val numbers = listOf(1, 2, 3, 4, 5)
    val sum = sumNumbers(numbers)
    val max = findMax(numbers)
    displayResults(sum, max)
}