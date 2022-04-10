import java.io.*
import com.fasterxml.jackson.module.kotlin.*

class Main {
    val mapper = jacksonObjectMapper()

    fun handler(input: InputStream, output: OutputStream): Unit {
        val inputObj = mapper.readValue<HandlerInput>(input)
        val operations = listOf("ADD", "SUBTRACT", "MULTIPLY", "DIVIDE")
        val operation = inputObj.operation
        val first_number = inputObj.first_number
        val second_number = inputObj.second_number
        if (operation in operations) {
            val modelObj = Model()
            val opOutput = modelObj.arithOps(first_number, second_number, operation)
            mapper.writeValue(output, HandlerOutput(opOutput))
        } else {
            mapper.writeValue(output, "Operation ${operation} not supported!")
        }
    }
}
