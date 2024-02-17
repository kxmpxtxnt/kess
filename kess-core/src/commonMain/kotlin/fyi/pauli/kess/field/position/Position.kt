package fyi.pauli.kess.field.position

import kotlinx.collections.immutable.persistentMapOf
import kotlin.math.ceil

/**
 * @author Paul Kindler
 * @since 16/02/2024
 */
private val charValue = persistentMapOf(
	'a' to 1,
	'b' to 2,
	'c' to 3,
	'd' to 4,
	'e' to 5,
	'f' to 6,
	'g' to 7,
	'h' to 8
)

public data class Position(
	val x: Char,
	val y: Int
) {

	init {
		if (!charValue.keys.contains(x)) throw IllegalArgumentException("X must be between a-h")
		if (!charValue.values.contains(y)) throw IllegalArgumentException("Y must be between 1-8")
	}

	public constructor(positionNumber: Int) : this(
		charValue.filterValues { it == (64 - ((ceil(positionNumber.toDouble() / 8 - 9) * -1).toInt()) * 8 - positionNumber) * -1 }.keys.first(),
		(ceil(positionNumber.toDouble() / 8 - 9) * -1).toInt()
	)

	val positionNumber: Int = 64 - (y * 8) + charValue[x]!!

	public operator fun inc(): Position = Position(positionNumber + 1)
}

public inline infix fun Char.at(y: Int): Position = Position(this, y)