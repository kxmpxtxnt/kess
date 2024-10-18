/*
 * Copyright 2024 Paul Kindler and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package fyi.pauli.kess.board.piece

import kotlinx.serialization.*

/**
 * Structure of a piece.
 * @param character Character in uppercase representing a piece.
 * @param weight Weight of the piece.
 */
@Serializable
abstract class Piece(
    open var character: Char,
    open val weight: Byte,
)
