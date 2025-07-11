package fyi.pauli.kess.figure

import fyi.pauli.kess.board.*
import fyi.pauli.kess.piece.*
import kotlin.getValue
import kotlin.jvm.JvmInline

internal fun createFigure(piece: Piece, color: Color): Int {
    return ((piece.id and 0b111) shl 1) or color.id
}

@JvmInline
value class Figure internal constructor(val id: Int) {

    val piece: Piece
        get() = piece(id and 0b1)

    val color: Color
        get() = color((id shr 1) and 0b111)

    constructor(piece: Piece, color: Color) : this(createFigure(piece, color))
}
