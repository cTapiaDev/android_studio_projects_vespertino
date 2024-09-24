package cl.bootcamp.clasesfundamentoskotlin

import android.app.Person

fun main() {

    // ----- FILTER -----
    println("---------- FILTER ----------")
    val nombres = listOf("Luis", "Maria", "Pedro", "Arturo", "Juan")
    val nombreRes = nombres.filter { it.contains("a", ignoreCase = true) }
    //println(nombreRes)

    val personas = listOf(
        Persona("Luis", 25),
        Persona("Maria", 18),
        Persona("Pedro", 48),
        Persona("Arturo", 40),
        Persona("Juan", 37)
    )

    val mayores = personas
        .filter { it.edad >= 30 }
        .map { it.nombre }
    println(mayores)

    // ----- MAP -----
    println("---------- MAP ----------")
    val listPersonas = personas.map { it.nombre }
    println(listPersonas)

    val multiEdad = personas.map { it.edad * 2 }
    println(multiEdad)

    val sumarEdades = personas.map { it.edad }.sum()
    println(sumarEdades)

    val extPalabras = personas.map { it.nombre.length }
    println(extPalabras)

    // ----- REDUCE -----
    println("---------- REDUCE ----------")
    val num = listOf(1, 2, 3, 4, 5)
    val numRes = num.reduce { valorAcumulado, i -> valorAcumulado * i  }
    println(numRes)

    val palabras = listOf("hola", "mundo", "en", "kotlin")
    val concatenar = palabras.reduce { acumulado, actual -> "$acumulado $actual"  }
    println(concatenar)

}

data class Persona(val nombre: String, val edad: Int)