package com.jaap.kotlin

// Interface
interface Signatory {

    fun sign()

    fun defaultSign() = println("Default sign")
}

// Open class
open class Person(val name: String, var age: Int) : Signatory {

    override fun sign() = println("$name is $age years old")
}

// Final class
class Employee(name: String, age: Int, var enterprise: Enterprise) : Person(name, age), Signatory {

    var role : String = ""

    override fun defaultSign() = println("$name works at ${enterprise.name} (${enterprise.city.name} - ${enterprise.city.country.name}) as $role")
}

// Data classes
data class Country(val name: String)

data class City(val name: String, val country: Country)

data class Enterprise(val name: String, val city: City)

// Main
fun main(args: Array<String>) {

    val person = Person("Jonathan", 29)
    person.age = 30
    person.sign()
    person.defaultSign()

    var endava = Enterprise("Endava", City("Bogotá", Country("Colombia")))
    val employee = Employee("Luisa", 30, endava)
    employee.sign()
    employee.role = "TechLead"
    employee.defaultSign()

    val (name, city) = endava
    println("$name is located in ${city.name}")

    val bizagi = endava.copy(name = "Bizagi")
    println("${bizagi.name} is located in ${bizagi.city.name}")

}