/*
 * Copyright 2024 Paul Kindler and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package fyi.pauli.kess.board

import fyi.pauli.kess.utils.serializer.*
import kotlinx.serialization.*
import kotlin.uuid.*

@OptIn(ExperimentalUuidApi::class)
@Serializable
public data class Board(
    @Serializable(with = UuidSerializer::class) val uuid: Uuid = Uuid.random(),
    val fields: MutableSet<Field> = buildSet {
        for (line in 'a'..'h') {
            for (row in 1..8) {
                add(Field(line, row))
            }
        }
    }.toMutableSet(),
)

@OptIn(ExperimentalUuidApi::class)
public fun chess(init: Board.() -> Unit): Board = Board().apply(init)
