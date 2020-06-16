package com.github.educar

import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    println("Hello, this is my first Docker app using JVM!")
    println("Starting server...")

    val server = embeddedServer(Netty, port = 8080) {
        routing {
            get("/hello") {
                call.respondText("Hello from Ktor!")
            }
        }
    }
    server.start(wait = true)
}
