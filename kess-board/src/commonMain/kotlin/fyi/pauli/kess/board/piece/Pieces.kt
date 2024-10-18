/*
 * Copyright 2024 Paul Kindler and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package fyi.pauli.kess.board.piece

/**
 * King piece with character 'k' and max weight as it is never really taken.
 */
object King : Piece(
    'K',
    Byte.MAX_VALUE
)

/**
 * Queen piece with character 'q' and weight of 8.
 */
object Queen : Piece(
    'Q',
    8
)

/**
 * Queen piece with character 'r' and weight of 5.
 */
object Rook : Piece(
    'R',
    5
)

/**
 * Queen piece with character 'b' and weight of 3.
 */
object Bishop : Piece(
    'B',
    3
)

/**
 * Queen piece with character 'n' and weight of 3.
 */
object Knight : Piece(
    'N',
    3
)

/**
 * Queen piece with character 'p' and weight of 1.
 */
object Pawn : Piece(
    'P',
    1
)
