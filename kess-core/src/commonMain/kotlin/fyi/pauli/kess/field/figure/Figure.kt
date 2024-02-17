package fyi.pauli.kess.field.figure

import fyi.pauli.kess.field.position.Position
import fyi.pauli.kess.piece.Piece

/**
 * @author Paul Kindler
 * @since 16/02/2024
 */
public data class Figure(
	val piece: Piece,
	val color: Color = if (piece.fenId.isLowerCase()) Color.BLACK else Color.WHITE,
	var position: Position
) {

	public val identifier: String = "${piece.name}_${color.name.lowercase()}_${position.positionNumber}"

	public enum class Color {
		WHITE,
		BLACK;

		public fun applyColor(char: Char): Char = if (this == WHITE) char.uppercaseChar() else char.lowercaseChar()
	}
}

public fun Char.color(): Figure.Color = if (this.isUpperCase()) Figure.Color.WHITE else Figure.Color.BLACK

