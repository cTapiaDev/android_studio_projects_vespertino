package cl.bootcamp.clasesfundamentoskotlin

fun main() {

    var array = arrayOf("Luis", "Mario", 2, 1.5, true)
    println(array.contentToString())
    println(array[1])
    println(array.size)

    var numeros = intArrayOf(1, 2, 3, 4, 5)
    println(numeros.contentToString())

    array += "Este es un nuevo dato"
    //array = array + "Este es un nuevo dato" // Es lo mismo que lo de arriba, solo que más extenso
    println(array.contentToString())

    var nums = intArrayOf(8, 4, 2, 3, 0, 9, 5)
    println(nums.contentToString())
    nums.sort()
    println(nums.contentToString())

    var nums2 = nums.toMutableList()
    nums2.remove(8)
    println(nums2)

    var array2 = array.toMutableList()
    array2.remove(2)
    println(array2)

}