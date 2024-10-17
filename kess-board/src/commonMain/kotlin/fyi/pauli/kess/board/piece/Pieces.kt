/*
 * Copyright 2024 Paul Kindler and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package fyi.pauli.kess.board.piece

/**
 * King piece with character 'k' and max weight as it is never really taken.
 */
object King : Piece(
    CharIdentifier(75, 107),
    Byte.MAX_VALUE
)

/**
 * Queen piece with character 'q' and weight of 8.
 */
object Queen : Piece(
    CharIdentifier(81, 113),
    8
)

/**
 * Queen piece with character 'r' and weight of 5.
 */
object Rook : Piece(
    CharIdentifier(82, 114),
    5
)

/**
 * Queen piece with character 'b' and weight of 3.
 */
object Bishop : Piece(
    CharIdentifier(66, 98),
    3
)

/**
 * Queen piece with character 'n' and weight of 3.
 */
object Knight : Piece(
    CharIdentifier(78, 110),
    3
)

/**
 * Queen piece with character 'p' and weight of 1.
 */
object Pawn : Piece(
    CharIdentifier(80, 112),
    1
)
