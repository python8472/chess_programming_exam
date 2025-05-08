package chess.pieces;

import chess.*;

import java.util.ArrayList;
import java.util.Collection;

public class moveHelper {
    public static Collection<ChessMove> getMoves(
            ChessBoard board,
            ChessPosition start,
            ChessGame.TeamColor color,
            int[][] directions,
            boolean isSliding){

        Collection<ChessMove> moves = new ArrayList<>();
        for(int[] dir : directions){
            int row = start.getRow();
            int col = start.getColumn();
            while(true){
                row += dir[0];
                col += dir[1];
                if(row<1 || row >8 || col <1 || col> 8) break;
                ChessPosition position = new ChessPosition(row, col);
                ChessPiece target = board.getPiece(position);
                if(target == null){
                    moves.add(new ChessMove(start, position, null));
                } else{
                    if(target.getTeamColor() != color){
                        moves.add(new ChessMove(start, position, null));
                    }
                    break;
                }
                if (!isSliding) break;
            }
        }

        return moves;
    }
}
