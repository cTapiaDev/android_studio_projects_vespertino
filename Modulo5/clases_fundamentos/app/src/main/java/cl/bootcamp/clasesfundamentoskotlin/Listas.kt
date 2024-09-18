package cl.bootcamp.clasesfundamentoskotlin

fun main() {

    val lista = listOf(1, 2, 3, 4, 5)
    println(lista)
    println(lista[0])

    val colores = listOf("Verde", "Amarillo", "Rojo")
    println(colores)


    val lista2 = mutableListOf(1, 2, 3)
    lista2.add(4)
    println(lista2)
    lista2.add(8)
    //lista2.add("hola")
    println(lista2)

    lista2.remove(3)
    println(lista2)

    lista2.sortDescending()
    println(lista2)


}
