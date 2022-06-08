package com.apjake.techquizzes.util


fun String.ifEmptyNull(): String? = this.ifEmpty { null }

fun Int.ifThisNull(value: Int): Int? = if(this==value) null else this

fun Int.ifMinusOneNull(): Int? = this.ifThisNull(-1)

fun Int?.orZero(): Int = this?:0

fun String?.toShortName(
    length: Int = 2,
    delimiter: String = " "
): String {
    var size = length
    if(this.isNullOrBlank()) return "?".repeat(size)
    val arr = this.uppercase().split(delimiter).map { it.first() }
    size = if(size>=arr.size) arr.size else size
    return arr.joinToString(separator = "").substring(0, size)
}