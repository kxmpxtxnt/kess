package fyi.pauli.kess.piece

value class Piece internal constructor(val id: Int) {

    val value: Int
        get() = when (id) {
            0 -> 1
            1 -> 3
            2 -> 3
            3 -> 5
            4 -> 9
            5 -> Int.MAX_VALUE
            else -> throw IllegalStateException("Id must be between 0 and 5.")
        }

    val character: Char
        get() = when(id) {
            0 -> 'p'
            1 -> 'n'
            2 -> 'b'
            3 -> 'r'
            4 -> 'q'
            5 -> 'k'
            else -> throw IllegalStateException("Id must be between 0 and 5.")
        }
}

val Pawn = Piece(0)
val Knight = Piece(1)
val Bishop = Piece(2)
val Rook = Piece(3)
val Queen = Piece(4)
val King = Piece(5)
