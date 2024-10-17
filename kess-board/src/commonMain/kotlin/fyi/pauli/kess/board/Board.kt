/*
 * Copyright 2024 Paul Kindler and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package fyi.pauli.kess.board

import fyi.pauli.kess.board.piece.*
import fyi.pauli.kess.utils.serializer.*
import kotlinx.serialization.*
import kotlin.uuid.*

@OptIn(ExperimentalUuidApi::class)
@Serializable
data class Board(
    @Serializable(with = UuidSerializer::class) val uuid: Uuid = Uuid.random(),
    val positions: MutableSet<Position> = buildSet {
        for (line in 1 .. 8) {
            for (row in 1..8) {
                add(Position(line, row))
            }
        }
    }.toMutableSet(),
    val pieces: MutableSet<Piece> = mutableSetOf()
)

@OptIn(ExperimentalUuidApi::class)
fun chess(init: Board.() -> Unit): Board = Board().apply(init)
