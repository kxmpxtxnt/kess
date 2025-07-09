package fyi.pauli.kess.board

import fyi.pauli.kess.board.field.EMPTY_FIELD
import fyi.pauli.kess.board.field.Field

value class Board(private val fields: Array<Field> = Array(64) { Field(EMPTY_FIELD) }) {

    operator fun get(index: Int): Field {
        return fields[index]
    }
}
