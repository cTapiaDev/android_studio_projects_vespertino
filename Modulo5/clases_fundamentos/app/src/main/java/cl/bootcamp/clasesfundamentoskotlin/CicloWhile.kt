package cl.bootcamp.clasesfundamentoskotlin

fun main() {

//    var num = 1
//    while (num <= 10) {
//        println(num)
//        num++
//    }

    var num1: Int = 0
    var num2: Int = 0

    while (true) {
        try {
            println("Ingresa el primer numero")
            num1 = readln().toInt()

            println("Ingresa el segundo numero")
            num2 = readln().toInt()
            break

        } catch (e: NumberFormatException) {
            println("Error: ingresa un dato valido")
        }
    }

    val suma = num1 + num2
    println("La suma es: $suma")


}