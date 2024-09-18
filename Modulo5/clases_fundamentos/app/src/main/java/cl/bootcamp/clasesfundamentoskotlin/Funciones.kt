package cl.bootcamp.clasesfundamentoskotlin

fun main() {

    suma(10, 15)

    println(division(10.0, 2.0))

    val result = division(10.0, 2.0)
    println("La division es: $result")


    /*** Funcion LAMBDA ***/
    val resta = { num1: Int, num2: Int -> println(num1 - num2) }
    resta(10, 5)
}

fun suma(num1: Int, num2: Int): Unit {
    val suma = num1 + num2
    println("Suma: $suma")
}

fun division (num1: Double, num2: Double): Double {
    val res = num1 / num2
    return res
}