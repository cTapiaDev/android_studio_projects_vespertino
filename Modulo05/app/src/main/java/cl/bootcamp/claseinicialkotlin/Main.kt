package cl.bootcamp.claseinicialkotlin

fun main() {

    /* println("Hola Mundo") */

    /*** VARIABLES ***/
    var nombre: String = "Wolverine"
    var texto = "Hola a todos"

    var num1: Int = 1
    var num2 = 2
    num2 = 34

    // Val es una constante
    val edad = 25

    //println(edad)

    /*** NULL SAFETY ***/
    var text: String? = ""

    text = null

    text?.let {
        println("Tiene un valor")
    }

    /*** CAMBIAR TIPO DE DATO ***/

    var num4 = 15
    var num5 = "5".toInt()
    var suma = num4 + num5
    //println(suma)

    /*** CONCATENACIONES ***/
    var t1 = "Hola"
    var t2 = "Mundo"
    //println(t1 + " " + t2)

    var result = t1.plus(" ").plus(t2)
    //println(result)

    val array = arrayOf("Hola", "Mundo")
    val result2 = array.joinToString(" ")
    //println(result2)

    //println("$t1 $t2 desde Kotlin")

    /*** ESCRIBIR POR CONSOLA ***/
//    println("Escribe tu nombre")
//    val user = readln()
//    println(user)

//    println("Ingresa el primer numero")
//    var n1 = readln().toInt()
//
//    println("Ingresa el segundo numero")
//    var n2 = readln().toInt()
//
//    var suma2 = n1 + n2
//    println("La suma es: $suma2")

    /*** Try / Catch ***/

    try {
        println("Ingresa el primer numero")
        var n1 = readln().toInt()

        println("Ingresa el segundo numero")
        var n2 = readln().toInt()

        var suma2 = n1 + n2
        println("La suma es: $suma2")
    } catch (e: NumberFormatException) {
        println("Error: ingresa un dato valido - ${e}")
    }

}