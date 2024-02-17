package fyi.pauli.kess.field.fen.castle

import fyi.pauli.kess.field.figure.Figure

/**
 * @author Paul Kindler
 * @since 17/02/2024
 */
public data class CastleRight(
	public val side: Side,
	public val color: Figure.Color
) {

	public enum class Side {
		QUEEN_SIDE,
		KING_SIDE
	}
}