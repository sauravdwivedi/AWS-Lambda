package com.aws.blog.jvmlangs.kotlin

import java.io.*
import com.fasterxml.jackson.module.kotlin.*

data class HandlerInput(val first_number: Double, val second_number: Double, val operation: String)
data class HandlerOutput(val result: Double)

class Main {
    val mapper = jacksonObjectMapper()

    fun handler(input: InputStream, output: OutputStream): Unit {
        val inputObj = mapper.readValue<HandlerInput>(input)
        val operations = listOf("ADD", "SUBTRACT", "MULTIPLY", "DIVIDE")
        var result = 0.0
        var errorMessage = ""
        if (inputObj.operation in operations) {
            if (inputObj.operation == "ADD") {
                result = inputObj.first_number + inputObj.second_number
            } else if (inputObj.operation == "SUBTRACT") {
                result = inputObj.first_number - inputObj.second_number
            } else if (inputObj.operation == "MULTIPLY") {
                result = inputObj.first_number * inputObj.second_number
            } else if (inputObj.operation == "DIVIDE" && inputObj.second_number == 0.0){
                errorMessage = "Number can't be divided by zero!"
                mapper.writeValue(output, errorMessage)
            } else {
                result = inputObj.first_number / inputObj.second_number
            }
            if (errorMessage == "") {
                mapper.writeValue(output, HandlerOutput(result))
            }
        } else {
            mapper.writeValue(output, "Operation ${inputObj.operation} not supported!")
        }
    }
}
