package shogi.gui;

import shogi.board.GameBoard;
import shogi.board.Position;
import shogi.piece.ChessMen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.TimerTask;

/**
 * @author sina
 * @version 1.0
 * Created by sina on 4/5/16.
 */
public class GameMap extends JPanel {
    private GameBoard gameBoard;
    private ChessMen[][] table;
    private ArrayList<Cell> cells = new ArrayList<>();
    private GridLayout gl;


    public GameMap (){
        this.setSize(630,630);
        this.setLocation((1000-640)/2,200);
        gameBoard = new GameBoard();
        table = gameBoard.getTable();
        this.mapInitializer();
    }

    int r,c;
    private void mapInitializer(){
        int i = 0;
        for(r=0 ; r<9 ;r++){
            for(c=0; c<9 ; c++){
            Cell a = new Cell(new Position(r,c), gameBoard);
                this.add (a);
                cells.add(a);

            }
        }
    }
//    private void ChessmenInitializer(){
//        for (int r =0 ; r<9 ; r++){
//            for ( int c = 0 ; c<9 ; c++){
//                if(table[r][c] != null){
//                    this.add(new ChessMan(gameBoard , new Position(r,c)));
//                }
//            }
//
//        }
//
//    }



}
