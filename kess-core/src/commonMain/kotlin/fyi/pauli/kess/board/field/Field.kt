package fyi.pauli.kess.board.field

const val EMPTY_FIELD = 0

value class Field(private val content: Int) {

    val isEmpty: Boolean get() = content == EMPTY_FIELD

}
