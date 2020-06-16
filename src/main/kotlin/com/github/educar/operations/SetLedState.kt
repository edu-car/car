package com.github.educar.operations

import com.pi4j.io.gpio.GpioFactory
import com.pi4j.io.gpio.GpioPinDigitalOutput
import com.pi4j.io.gpio.PinState
import com.pi4j.io.gpio.RaspiPin
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.post

data class SetLedStateRequest(val turnedOn: Boolean)
data class SetLedStateResponse(val message: String)

val ledPin = initLedPin()

fun Route.setLedState() = post("/setLedState") {
    val request = call.receive<SetLedStateRequest>()
    println("Request: $request")

    ledPin.setState(request.turnedOn)

    val response = SetLedStateResponse(
            message = "LED state changed to ${if (request.turnedOn) "ON" else "OFF"}")
    println(response)
    call.respond(HttpStatusCode.OK, response)
}

fun initLedPin(): GpioPinDigitalOutput =
        with (GpioFactory.getInstance()) {
            return provisionDigitalOutputPin(RaspiPin.GPIO_08, PinState.LOW)
        }
