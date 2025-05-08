package chess.pieces;

import chess.ChessBoard;
import chess.ChessGame;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.Collection;

import static chess.pieces.moveHelper.getMoves;

public class rook {
    public static Collection<ChessMove> getRookMoves(
            ChessBoard board,
            ChessPosition start,
            ChessGame.TeamColor color){
        int[][] directions = {
                      {-1,0},
                {0,-1},      {0,1},
                       {1,0}
        };
        return getMoves(board,start,color,directions,true);
    }
}
