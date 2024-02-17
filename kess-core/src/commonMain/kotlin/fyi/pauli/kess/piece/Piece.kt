package fyi.pauli.kess.piece

/**
 * @author Paul Kindler
 * @since 16/02/2024
 */
public abstract class Piece(
	public val name: String,
	public val value: Int,
	public val startQuantity: Int,
	public val fenId: Char,
) {

	public abstract class Pawn(name: String, value: Int, startQuantity: Int, fenId: Char) : Piece(
		name,
		value,
		startQuantity,
		fenId
	)

	public abstract class Knight(name: String, value: Int, startQuantity: Int, fenId: Char) : Piece(
		name,
		value,
		startQuantity,
		fenId
	)

	public abstract class Bishop(name: String, value: Int, startQuantity: Int, fenId: Char) : Piece(
		name,
		value,
		startQuantity,
		fenId
	)

	public abstract class Rook(name: String, value: Int, startQuantity: Int, fenId: Char) : Piece(
		name,
		value,
		startQuantity,
		fenId
	)

	public abstract class Queen(name: String, value: Int, startQuantity: Int, fenId: Char) : Piece(
		name,
		value,
		startQuantity,
		fenId
	)

	public abstract class King(name: String, value: Int, startQuantity: Int, fenId: Char) : Piece(
		name,
		value,
		startQuantity,
		fenId
	)
}