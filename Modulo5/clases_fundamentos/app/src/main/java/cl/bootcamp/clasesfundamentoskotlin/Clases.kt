package cl.bootcamp.clasesfundamentoskotlin

fun main() {
    val persona = Personas("Jorge", 38)
    persona.saludar()

    val user = Usuarios("Pedro", "pedro@gmail.com")
    user.login()
}


class Personas {
    // Atributos
    private var nombre = ""
    private var edad = 0

    // Constructor secundario
    constructor(nombre: String, edad: Int) {
        this.nombre = nombre
        this.edad = edad
    }

    // Métodos
    fun saludar() {
        println("Hola, me llamo ${this.nombre} y tengo ${this.edad} años.")
    }
}

/*** CONSTRUCTOR PRIMARIO ***/
class Usuarios(
    private var nombre: String,
    private var email: String
) {
    fun login() {
        println("Login con user: ${this.nombre}, email: ${this.email}")
    }
}