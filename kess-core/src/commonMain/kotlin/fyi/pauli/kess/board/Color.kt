package fyi.pauli.kess.board

import kotlin.jvm.JvmInline

@JvmInline
value class Color internal constructor(val id: Int)

val White = Color(0)
val Black = Color(1)
