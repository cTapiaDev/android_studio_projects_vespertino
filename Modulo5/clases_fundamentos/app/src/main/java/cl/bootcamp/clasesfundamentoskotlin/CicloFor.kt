package cl.bootcamp.clasesfundamentoskotlin

fun main() {

//    for (i in 1..5) {
//        println(i)
//    }

//    for (a in 'a'..'z') {
//        println(a)
//    }

//    for (a in 'z' downTo  'a') {
//        println(a)
//    }

//    for (i in 5 downTo 1) {
//        println(i)
//    }

    val users = arrayOf("Luis", "Diego", "Laura", "Jorge")
    for (user in users.indices) {
        println("${user}: ${users[user]}")
    }


    /*** FOR EACH ***/
    val list = listOf(1, 2, 3, 4, 5)
    list.forEach { println(it) }


    list.forEachIndexed { index, element ->
        println("$index - ${element}")
    }


}