package fyi.pauli.kess.figure

import fyi.pauli.kess.board.*
import fyi.pauli.kess.piece.*

internal fun createFigure(piece: Piece, color: Color): Int {
    return ((piece.id and 0b111) shl 1) or color.id
}

value class Figure internal constructor(private val id: Int) {

    constructor(piece: Piece, color: Color) : this(createFigure(piece, color))
}
