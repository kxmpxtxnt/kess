package fyi.pauli.kess.field.fen

import fyi.pauli.kess.field.Field
import fyi.pauli.kess.field.fen.castle.CastleRight
import fyi.pauli.kess.field.figure.Figure
import fyi.pauli.kess.field.figure.color
import fyi.pauli.kess.field.position.Position
import fyi.pauli.kess.field.position.at
import fyi.pauli.kess.piece.Pieces

public object FenSerializer {

	public const val DEFAULT_FEN: String = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w - - 0 0"

	public fun fromFen(fen: String = DEFAULT_FEN): Field {
		val parts = fen.split(" ")

		parts.forEachIndexed { index, c ->
			println("$index - $c")
		}

		var currentPosition: Int
		var skips: Array<Int> = emptyArray()

		val figures = buildSet {
			parts[0].split("/").joinToString(separator = "") { it }.forEachIndexed { index, char ->
				char.digitToIntOrNull()?.let { skips += it }
				currentPosition = index + 1 + skips.sum() - skips.size

				if (char.isLetter()) add(
					Figure(
						piece = Pieces.find(char),
						position = Position(currentPosition)
					)
				)
			}
		}

		val color = if (parts[1] == "w") Figure.Color.WHITE else Figure.Color.BLACK

		val castlingRights = buildSet {
			parts[2].forEach { c ->
				add(
					CastleRight(
						if (c.lowercaseChar() == 'q') CastleRight.Side.QUEEN_SIDE else CastleRight.Side.KING_SIDE,
						c.color()
					)
				)
			}
		}

		val enPassent: Position? = parts[3].let { if (it.isEmpty()) null else (it.first() at it.last().digitToInt()) }

		return Field(
			figures.toMutableSet(),
			color,
			castlingRights.toMutableSet(),
			enPassent,
			parts[4].toInt(),
			parts[5].toInt()
		)
	}
}

public fun main() {
	FenSerializer.fromFen("rnbqkbnr/pppppppp/8/8/4P3/8/PPPP1PPP/RNBQKBNR b KQkq e3 0 1")
}