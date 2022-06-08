package com.apjake.techquizzes.data.network

object HttpStatusCode {
    fun toMessage(code: Int): String{
        return when(code){
            400 -> "Bad Request"
            401 -> "Sorry, you are not authorized!"
            402 -> "Sorry, payment is required!"
            403 -> "Forbidden! you are not allowed to do this stuff"
            404 -> "404, Not Found!"
            405 -> "Method not allowed!"
            in 500..599 -> "Server Error! Please try again later."
            else -> "Unhandled status code error!"
        }
    }
}