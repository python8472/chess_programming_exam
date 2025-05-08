package chess.pieces;

import chess.*;

import java.util.ArrayList;
import java.util.Collection;

public class pawn {
    public static Collection<ChessMove> getMoves(
            ChessBoard board,
            ChessPosition start,
            ChessGame.TeamColor color){
        int startRow = (color == ChessGame.TeamColor.WHITE) ? 2: 7;
        int direction = (color == ChessGame.TeamColor.WHITE) ? 1: -1;
        Collection<ChessMove> moves = new ArrayList<>();


        int row = start.getRow();
        int col = start.getColumn();

        // ChessPosition oneForward
        ChessPosition oneForward = new ChessPosition(row+direction,col);
        if(inBounds(oneForward) && board.getPiece(oneForward)==null){
            addMovePromo(moves,start,oneForward,color);
            ChessPosition twoForward = new ChessPosition(row + 2 * direction,col);
            if(row==startRow &&
                    inBounds(twoForward) &&
                    board.getPiece(twoForward)==null){
                moves.add(new ChessMove(start,twoForward,null));
            }
        }

        //diagonal
        for(int dCol : new int[]{-1,1}){
            int newCol = col + dCol;
            int newRow = row + direction;
            ChessPosition diag = new ChessPosition(newRow,newCol);
            if(inBounds(diag)){
                ChessPiece target = board.getPiece(diag);
                if(target != null && target.getTeamColor() != color){
                    addMovePromo(moves,start,diag,color);
                }
            }
        }

        return moves;
    }

    private static boolean inBounds(ChessPosition pos){
        return pos.getRow() >= 1 &&
                pos.getRow() <= 8 &&
                pos.getColumn() >= 1 &&
                pos.getColumn() <= 8;
    }

    private static void addMovePromo(Collection<ChessMove> moves,
                                    ChessPosition start,
                                    ChessPosition end,
                                    ChessGame.TeamColor color){
        int promoRow = (color == ChessGame.TeamColor.WHITE) ? 8: 1;
        if(end.getRow() == promoRow){
            for(ChessPiece.PieceType promo : new ChessPiece.PieceType[]{
                    ChessPiece.PieceType.QUEEN,
                    ChessPiece.PieceType.ROOK,
                    ChessPiece.PieceType.BISHOP,
                    ChessPiece.PieceType.KNIGHT
            }){
                moves.add(new ChessMove(start, end, promo));
            }
        } else {
            moves.add(new ChessMove(start, end, null));
        }

    }


}
