package fyi.pauli.kess.fen

import fyi.pauli.kess.board.*
import fyi.pauli.kess.figure.*
import fyi.pauli.kess.piece.*

const val DEFAULT_FEN = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1"

private operator fun List<String>.component6() = this[5]

fun board(fen: String, body: Board.() -> Unit = {}): Board {
    val board = board()
    var index = 0

    val pieces: Map<Char, Piece> = listOf(
        Pawn,
        Knight,
        Bishop,
        Rook,
        Queen,
        King
    ).associateBy(Piece::character)

    val (lineup, color, castling, enpassant, halfmove, fullmove) = fen.split(" ")

    lineup.forEach { character ->
        if (character == '/') return@forEach
        if (character.isDigit()) {
            index += character.digitToInt()
            return@forEach
        }

        val piece = pieces[character.lowercaseChar()]

        requireNotNull(piece) {
            "Invalid character '$character' in given fen."
        }

        val color = if (character.isLowerCase()) Black else White

        val actualIndex = (7 - index / 8) * 8 + (index % 8)

        board[actualIndex] = Figure(piece, color)

        index++
    }

    return board.apply(body)
}
