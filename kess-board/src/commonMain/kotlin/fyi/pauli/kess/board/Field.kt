/*
 * Copyright 2024 Paul Kindler and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package fyi.pauli.kess.board

import kotlinx.serialization.*

/**
 * Representation of a field on a chess board consisting of [line] and [row].
 */
@Serializable
public data class Field(
    val line: Byte, // [a-h]
    val row: Byte, // [1-8]
) {

    private val range = arrayOf<Byte>(1, 2, 3, 4, 5, 6, 7, 8)

    init {
        require(range.contains(line)) { "Line must be between [a-h]." }
        require(range.contains(row)) { "Row must be between [1-8]." }
    }

    public constructor(line: Byte, row: Int) : this(line, row.toByte())
    public constructor(line: Byte, row: Number) : this(line, row.toByte())
    public constructor(line: Number, row: Number) : this(line.toByte(), row.toByte())
    public constructor(line: Char, row: Byte) : this((line.lowercaseChar().code - 96).toByte(), row)
    public constructor(line: Char, row: Int) : this((line.lowercaseChar().code - 96).toByte(), row.toByte())

    /**
     * Actual character of the field. Goes from a-h.
     */
    public val lineChar: Char
        get() = Char(line + 96)

    /**
     * Actual id of the field. Goes from 1-8.
     */
    public val id: Byte
        get() = (8 * row - (8 - line) - 1).toByte()

    /**
     * Converts [Pair] from given [Field].
     */
    public val pair: Pair<Byte, Byte>
        get() = Pair(line, row)
}

/**
 * Converts [Field] from given [Pair]
 */
public val Pair<Byte, Byte>.field: Field
    get() = Field(first, second)
