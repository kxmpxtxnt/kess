/*
 * Copyright 2024 Paul Kindler and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package fyi.pauli.kess.board.figure

import fyi.pauli.kess.board.*
import fyi.pauli.kess.board.piece.*
import kotlinx.serialization.*

@Serializable
data class Figure<P : Piece>(
    val piece: P,
    private var initialColor: Color = Color.WHITE,
    val position: Position,
) {

    var color: Color = initialColor
        set(value) {
            field = value
            piece.character.apply(value.body)
        }

    enum class Color(val body: Char.() -> Unit) {
        WHITE(Char::uppercaseChar),
        BLACK(Char::lowercaseChar)
    }
}
