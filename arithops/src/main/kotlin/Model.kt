
data class HandlerInput(
    val first_number: Double,
    val second_number: Double,
    val operation: String
    )

data class HandlerOutput(val result: Double)

class Model {
    fun arithOps(first_number: Double, second_number: Double, operation: String): Double{
        var result = 0.0
        if (operation == "ADD") {
            result = first_number + second_number
        } else if (operation == "SUBTRACT") {
            result = first_number - second_number
        } else if (operation == "MULTIPLY") {
            result = first_number * second_number
        } else {
            try {
                result = first_number / second_number
            } catch (e : ArithmeticException){
                println(e.message)
            }
        }
        return result
    }
}

fun main(args: Array<String>) {
    println("This is a Kotlin application with Gradle to implement basic " +
            "arithmetic operations such as 'ADD', 'SUBTRACT', 'MULTIPLY', 'DIVIDE'!")
}