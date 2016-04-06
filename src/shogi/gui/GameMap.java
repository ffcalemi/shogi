package shogi.gui;

import shogi.board.GameBoard;
import shogi.board.Position;
import shogi.piece.ChessMen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.TimerTask;

/**
 * @author sina
 * @version 1.0
 * Created by sina on 4/5/16.
 */
public class GameMap extends JPanel {
    private GameBoard gameBoard;
    private ChessMen[][] table = new ChessMen[9][9];
    private ArrayList<Cell> cells = new ArrayList<>();
    private  Position position;
    public Position getPosition() {
        return position;
    }

    public GameMap (GameBoard gm){
        this.setLayout(null);
        this.setSize(630,630);
        gameBoard = gm;
        this.setLocation((1000-640)/2,200);
        this.table = gameBoard.getTable();
        gameBoard = new GameBoard();
        table = gameBoard.getTable();
        this.mapInitializer();
        this.addMouseListener(new myMouselistener());

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
    class   myMouselistener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            ArrayList<Position> positions = new ArrayList<>();
            System.out.println(e.getX());
            System.out.println(e.getY());

            System.out.println("ssssss");
            ChessMen chessMen = table[e.getX()/70][e.getY()/70];
            System.out.println("chesmen  "+ chessMen.getPosition().getRow());
            System.out.println("chesmen  "+ chessMen.getPosition().getCol());
            System.out.println(chessMen.getPlayerRole());
            System.out.println(chessMen.getClass());

            positions = chessMen.calculatingMoves();
            for(  int i=0 ; i< positions.size(); i++){
                System.out.println(     cells.get(positions.get(i).getCol()*9 + positions.get(i).getRow()).getPosition().getCol());
                cells.get(positions.get(i).getCol()*9 + positions.get(i).getRow()).setBackground(Color.CYAN);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

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
