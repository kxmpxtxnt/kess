package fyi.pauli.kess.board.field

import fyi.pauli.kess.figure.*
import kotlin.jvm.*

const val EMPTY_FIELD: Int = 0

@JvmInline
value class Field(val content: Int) {

    val figure: Figure?
        get() = if (isEmpty) null else Figure(content)

    val isEmpty: Boolean get() = content == EMPTY_FIELD

}
