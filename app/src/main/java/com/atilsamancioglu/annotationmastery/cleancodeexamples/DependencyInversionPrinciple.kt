package com.atilsamancioglu.annotationmastery.cleancodeexamples

interface Repository {
    fun getData(): String
}
class DatabaseRepository : Repository {
    override fun getData() = "Data from database"
}
class NetworkRepository : Repository {
    override fun getData() = "Data from network"
}
class Service(private val repository: Repository) {
    fun getData(): String {
        return repository.getData()
    }
}

fun main() {
    val service = Service(DatabaseRepository())
    println(service.getData()) // prints "Data from database"

    val service2 = Service(NetworkRepository())
    println(service2.getData()) // prints "Data from network"

}


