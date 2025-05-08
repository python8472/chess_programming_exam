package chess.pieces;

import chess.*;

import java.util.ArrayList;
import java.util.Collection;

import static chess.pieces.moveHelper.getMoves;

public class kngt {
    public static Collection<ChessMove> getKngtMoves(
            ChessBoard board,
            ChessPosition start,
            ChessGame.TeamColor color){
        Collection<ChessMove> moves = new ArrayList<>();
        int[][] directions = {
                {-2,-1},{-2,1},
                {-1,-2},{-1,2},
                {1,-2},{1,2},
                {2,-1},{2,1}
        };
        for(int[] direction : directions){
            int newRow = start.getRow() + direction[0];
            int newCol = start.getColumn() + direction[1];

            if(newRow >= 1 && newRow <= 8 && newCol >= 1 && newCol <= 8){
                ChessPosition newPos = new ChessPosition(newRow,newCol);
                ChessPiece occupying = board.getPiece(newPos);
                if(occupying == null || occupying.getTeamColor() != color){
                    moves.add(new ChessMove(start, newPos, null));
                }
            }
        }
        return moves;
    }
}
