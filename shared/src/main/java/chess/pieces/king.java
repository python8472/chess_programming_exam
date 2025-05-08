package chess.pieces;


import chess.ChessBoard;
import chess.ChessGame;
import chess.ChessMove;
import chess.ChessPosition;
import java.util.Collection;
import static chess.pieces.moveHelper.getMoves;

public class king {
    public static Collection<ChessMove> getKingMoves(
            ChessBoard board,
            ChessPosition start,
            ChessGame.TeamColor color){
        int[][] directions = {
                {-1,-1},{-1,0},{-1,1},
                {0,-1},        {0,1},
                {1,-1}, {1,0}, {1,1}
        };
        return getMoves(board,start,color,directions,false);
    }
}
