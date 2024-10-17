/*
 * Copyright 2024 Paul Kindler and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package fyi.pauli.kess.board.piece

import kotlinx.serialization.*

/**
 * Structure of a piece.
 * @param colorId Character identifier for either white or black.
 * @param weight Weight of the piece.
 */
@Serializable
abstract class Piece(
    val colorId: CharIdentifier,
    val weight: Byte,
) {

    /**
     * Structure of the character identifier.
     * @param white Character code for a white piece.
     * @param black Character code for a black piece.
     */
    @Serializable
    data class CharIdentifier(
        val white: Byte,
        val black: Byte
    )
}
