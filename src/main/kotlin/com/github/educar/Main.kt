package com.github.educar

import com.github.educar.operations.setLedState
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import java.text.DateFormat

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
            setLedState()
        }
    }
    server.start(wait = true)
}
