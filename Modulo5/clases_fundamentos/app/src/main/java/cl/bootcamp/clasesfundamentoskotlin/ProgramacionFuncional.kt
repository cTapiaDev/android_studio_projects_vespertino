package cl.bootcamp.clasesfundamentoskotlin

fun main() {

    val num = listOf(1, 2, 3, 4, 5)
    val suma = sumarLista(num)
    println("La suma de la lista es: $suma")

    val datos = listOf(2, 3, 5, 6, 7, 8, 10, 12, 33, 4, 24, 29, 30)
    val listaPares = filtrarPares(datos)
    println(listaPares)

}

fun sumarLista(lista: List<Int>): Int {
    // Programación tradicional / imperativa
//    var res = 0
//    for (i in lista) {
//        res += i
//    }
//    return res

    // Programación funcional / declarativa
    return lista.sum()
}

fun filtrarPares(lista: List<Int>): List<Int> {
    // Programación tradicional / imperativa
//    val res = mutableListOf<Int>()
//    for (i in lista) {
//        if (i % 2 == 0) {
//            res.add(i)
//        }
//    }
//    return res

    // Programación funcional / declarativa
    return lista.filter { it % 2 == 0 }.toList()
}