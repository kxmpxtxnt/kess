/*
 * Copyright 2024 Paul Kindler and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package fyi.pauli.kess.board

import kotlin.test.*

class FieldConvertingTests {

    @Test
    fun convertFieldLineToChar() {
        val field = Field(5, 2)

        assertEquals(field.lineChar, 'e')
    }

    @Test
    fun calculateIdFromField() {
        val field = Field('d', 3)

        assertEquals(field.id, 19)
    }

}
