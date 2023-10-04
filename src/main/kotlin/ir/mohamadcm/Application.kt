package ir.mohamadcm

import io.ktor.server.application.*
import ir.mohamadcm.plugins.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    configureSecurity()
    configureHTTP()
    configureSerialization()
    configureSockets()
    configureRouting()
}
