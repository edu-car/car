package com.github.educar

import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.post
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import java.text.DateFormat

data class SetLedStateRequest(val turnedOn: Boolean)
data class SetLedStateResponse(val message: String)

fun main() {
    println("Hello, this is my first Docker app using JVM!")
    println("Starting server...")

    val server = embeddedServer(Netty, port = 8080) {
        install(ContentNegotiation) {
            gson {
                setDateFormat(DateFormat.LONG)
                setPrettyPrinting()
            }
        }

        routing {
            post("/setLedState") {
                val request = call.receive<SetLedStateRequest>()
                println("Request: $request")

                // TODO change Raspberry PI LED's state here.

                val response = SetLedStateResponse(
                        message = "LED state changed to ${if (request.turnedOn) "ON" else "OFF"}")
                println(response)
                call.respond(HttpStatusCode.OK, response)
            }
        }
    }
    server.start(wait = true)
}
