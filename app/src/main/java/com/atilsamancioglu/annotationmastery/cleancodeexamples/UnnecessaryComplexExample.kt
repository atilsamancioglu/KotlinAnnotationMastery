package com.atilsamancioglu.annotationmastery.cleancodeexamples

//Second Example

val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

fun Int.isEven(): Boolean = this % 2 == 0

fun List<Int>.processList(filterCondition: (Int) -> Boolean, action: (List<Int>) -> Int): Int {
    return action(this.filter(filterCondition))
}

fun main() {
    val result = numbers.processList(
        filterCondition = { it.isEven() },
        action = { list -> list.fold(0) { sum, element -> sum + element } }
    )
    println("Sum of even numbers: $result")
}

//Correct way

fun correctWay() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val sum = numbers.filter { it % 2 == 0 }.sum()

    println("Sum of even numbers: $sum")
}

