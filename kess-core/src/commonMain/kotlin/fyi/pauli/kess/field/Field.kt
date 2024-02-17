package fyi.pauli.kess.field

import fyi.pauli.kess.field.fen.castle.CastleRight
import fyi.pauli.kess.field.figure.Figure
import fyi.pauli.kess.field.position.Position

/**
 * @author Paul Kindler
 * @since 16/02/2024
 */
public data class Field (
	public val figures: MutableSet<Figure>,
	public val color: Figure.Color,
	public val castlingRights: MutableSet<CastleRight>,
	public val enPassent: Position?,
	public val halfMove: Int,
	public val fullMove: Int
)