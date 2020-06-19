package com.github.educar.operations

import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.post

data class SetLedStateRequest(val turnedOn: Boolean)
data class SetLedStateResponse(val message: String)

fun Route.setLedState() = post("/setLedState") {
    val request = call.receive<SetLedStateRequest>()
    println("Request: $request")

    // TODO change Raspberry PI LED's state here.

    val response = SetLedStateResponse(
            message = "LED state changed to ${if (request.turnedOn) "ON" else "OFF"}")
    println(response)
    call.respond(HttpStatusCode.OK, response)
}
