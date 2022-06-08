package com.apjake.techquizzes.util

interface UniMapper<A,B> {
    fun map(data: A): B
}