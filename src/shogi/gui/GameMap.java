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
            ChessMen chessMen = table[e.getY()/70][e.getX()/70];
            positions = chessMen.calculatingMoves();
            for(  int i=0 ; i< positions.size(); i++){
                System.out.println(cells.get(positions.get(i).getRow()*9 + positions.get(i).getCol()).getPosition().getCol());
                int n = positions.get(i).getCol()*9 + positions.get(i).getRow();
              Cell c =  cells.get(n);
                c.setBackground(c.getCorrectColor());
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            for ( Cell cell : cells){
                if( (cell.getPosition().getCol()+cell.getPosition().getRow())%2==0)
                cell.setBackground(cell.getEvenBackground());
                else cell.setBackground(cell.getOddBackgrand());
            }
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
