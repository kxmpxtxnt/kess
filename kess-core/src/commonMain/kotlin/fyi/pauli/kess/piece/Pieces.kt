package fyi.pauli.kess.piece

/**
 * @author Paul Kindler
 * @since 16/02/2024
 */
public object Pieces {

	public object Type {
		public fun pawn(id: Char): Piece.Pawn = object : Piece.Pawn(fenId = id, value = 1, startQuantity = 8, name = "pawn") {}

		public fun knight(id: Char): Piece.Knight = object : Piece.Knight(fenId = id, value = 3, startQuantity = 2, name = "knight") {}

		public fun bishop(id: Char): Piece.Bishop = object : Piece.Bishop(fenId = id, value = 3, startQuantity = 2, name = "bishop") {}

		public fun rook(id: Char): Piece.Rook = object : Piece.Rook(fenId = id, value = 5, startQuantity = 2, name = "rook") {}

		public fun queen(id: Char): Piece.Queen = object : Piece.Queen(fenId = id, value = 9, startQuantity = 1, name = "queen") {}

		public fun king(id: Char): Piece.King = object : Piece.King(fenId = id, value = 10, startQuantity = 1, name = "king") {}
	}

	public inline fun <reified P: Piece> find(id: Char): P = when (id.lowercaseChar()) {
		'p' -> Type.pawn(id)
		'n' -> Type.knight(id)
		'b' -> Type.bishop(id)
		'r' -> Type.rook(id)
		'q' -> Type.queen(id)
		else -> Type.king(id)
	} as P
}