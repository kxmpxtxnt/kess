/*
 * Copyright 2024 Paul Kindler and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package fyi.pauli.kess.board

import kotlin.test.*

class PositionConvertingTests {

    @Test
    fun convertPositionLineToChar() {
        val position = Position(5, 2)

        assertEquals(position.lineChar, 'e')
    }

    @Test
    fun calculateIdFromPosition() {
        val position = Position('d', 3)

        assertEquals(position.id, 19)
    }
}
