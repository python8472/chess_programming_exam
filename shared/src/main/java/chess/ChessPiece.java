package chess;

import chess.pieces.bish;
import chess.pieces.king;
import chess.pieces.queen;
import chess.pieces.kngt;
import chess.pieces.pawn;
import chess.pieces.rook;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import static chess.pieces.bish.getBishMoves;
/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {
    public ChessGame.TeamColor color;
    public  ChessPiece.PieceType piecetype;
    public ChessPiece(ChessGame.TeamColor pieceColor,
                      ChessPiece.PieceType type) {
        color = pieceColor;
        piecetype = type;
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    @Override
    public String toString() {
        return "ChessPiece{" +
                "color=" + color +
                ", piecetype=" + piecetype +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessPiece that = (ChessPiece) o;
        return color == that.color && piecetype == that.piecetype;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, piecetype);
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {

        return color;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        return piecetype;
    }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board,
                                            ChessPosition myPosition) {
        return switch (piecetype){
            case KING -> king.getKingMoves(board,myPosition,color);
            case QUEEN -> queen.getQueenMoves(board,myPosition,color);
            case BISHOP -> bish.getBishMoves(board,myPosition,color);
            case KNIGHT -> kngt.getKngtMoves(board,myPosition,color);
            case ROOK -> rook.getRookMoves(board,myPosition,color);
            case PAWN -> pawn.getMoves(board,myPosition,color);
        };

    }
}
