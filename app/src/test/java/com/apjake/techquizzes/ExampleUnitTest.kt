package com.apjake.techquizzes

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

}


fun toShortName(
    str: String?,
    length: Int = 2,
    delimiter: String = " "
): String {
    var size = length
    if(str.isNullOrBlank()) return "?".repeat(size)
    val arr = str.uppercase().split(delimiter).map { it.first() }
    size = if(size>=arr.size) arr.size else size
    return arr.joinToString(separator = "").substring(0, size)
}

fun short_name_testing() {
    val inputs = listOf<List<Any>>(
        listOf("Aung Minn Khant Chan Myae Thu", 2),
        listOf("Aung Minn Khant", 3),
        listOf("AP Jake", 1),
        listOf("AP Jake", 2),
        listOf("AP Jake", 3),
        listOf("Loki", 1),
        listOf("Loki", 2),
    )
    inputs.forEach {
        println(toShortName(it[0] as String, it[1] as Int))
    }
}