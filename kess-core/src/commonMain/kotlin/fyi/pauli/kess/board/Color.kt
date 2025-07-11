package fyi.pauli.kess.board

import kotlin.jvm.JvmInline

fun color(id: Int): Color = when(id) {
    0 -> White
    1 -> Black
    else -> throw IllegalStateException("Id must be between either be 0 or 1.")
}

@JvmInline
value class Color internal constructor(val id: Int)

val White = Color(0)
val Black = Color(1)
