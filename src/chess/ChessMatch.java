/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

/**
 *
 * @author gleywson
 */
public class ChessMatch {
    private Board board;

    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
    }
    
    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for(int i = 0; i < board.getRows(); i++) {
            for(int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }
    
    private void placeNewPice(char column, int row, ChessPiece piece) {
        board.placePice(piece, new ChessPosition(column, row).toPosition());
    }
    
    private void initialSetup() {
        placeNewPice('b', 6, new Rook(Color.WHITE, board));
        placeNewPice('e', 8, new King(Color.BLACK, board));
        placeNewPice('e', 1, new King(Color.WHITE, board));
    }
    
}
