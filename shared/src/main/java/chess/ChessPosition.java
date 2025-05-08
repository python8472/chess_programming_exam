package chess;

import java.util.Objects;

/**
 * Represents a single square position on a chess board
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPosition {
    private final int pieceRow;
    private final int pieceCol;

    public ChessPosition(int row, int col) {
        this.pieceRow = row;
        this.pieceCol = col;
    }

    @Override
    public String toString() {
        return "ChessPosition{" +
                "pieceRow=" + pieceRow +
                ", pieceCol=" + pieceCol +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessPosition position = (ChessPosition) o;
        return pieceRow == position.pieceRow && pieceCol == position.pieceCol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceRow, pieceCol);
    }

    /**
     * @return which row this position is in
     * 1 codes for the bottom row
     */
    public int getRow() {
        return pieceRow;
    }

    /**
     * @return which column this position is in
     * 1 codes for the left row
     */
    public int getColumn() {
        return pieceCol;
    }
}
