package fyi.pauli.kess.figure

import fyi.pauli.kess.board.*
import fyi.pauli.kess.piece.*
import kotlin.jvm.JvmInline

internal fun createFigure(piece: Piece, color: Color): Int {
    return ((piece.id and 0b111) shl 1) or color.id
}

@JvmInline
value class Figure internal constructor(val id: Int) {

    constructor(piece: Piece, color: Color) : this(createFigure(piece, color))
}
