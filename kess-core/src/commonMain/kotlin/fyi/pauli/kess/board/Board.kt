package fyi.pauli.kess.board

import fyi.pauli.kess.board.field.*
import fyi.pauli.kess.figure.*
import kotlin.jvm.*

@JvmInline
value class Board internal constructor(private val fields: Array<Int> = Array(64) { EMPTY_FIELD }) {

    operator fun get(index: Int): Field {
        require(index in 0..63) { "Index '$index' is out of bounds." }
        return Field(fields[index])
    }

    operator fun get(file: Char, rank: Int): Field {
        return get(indexOfFileAndRank(file, rank))
    }

    operator fun set(index: Int, figure: Figure) {
        fields[index] = Field(figure.id).content
    }

    operator fun set(file: Char, rank: Int, figure: Figure) {
        fields[indexOfFileAndRank(file, rank)] = Field(figure.id).content
    }

    private fun indexOfFileAndRank(file: Char, rank: Int): Int {
        val file = (file.code - 97)
        val actualRank = rank - 1
        require(file in 0..7) { "File '$this' is out of bounds." }
        require(actualRank in 0..7) { "Rank '$rank' is out of bounds." }

        return (actualRank * 8) + file
    }
}

fun board(body: Board.() -> Unit = {}): Board = Board().apply(body)
