package shogi.gui;


import shogi.board.GameBoard;
import shogi.board.Position;
import shogi.piece.ChessMen;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.IndexColorModel;

/**
 * @author sina
 * @version 1.0
 * Created by sina on 4/5/16.
 */
public class Cell  extends  JPanel{
    private int width = 70;
    private Position position;
    private Color wrongColor = new Color(255,0,0);
    private Color correctColor = new Color(0,255,0);
    private Color emptyColorWhite = new Color(255,255,255);
    private Color getEmptyColorBlack =  new Color(0,0,0);
    private GameBoard gameBoard ;
    private ChessMen[][] table;
    public int hasBull = 1;

    public Cell(Position pos, GameBoard gm) {
        this.position = pos;
        this.gameBoard = gm;
        this.table = gameBoard.getTable();
    }

    public void paint(Graphics g) {
        if((position.getRow()+position.getCol())%2 ==0){
            g.setColor(new Color(139,69,19));
        }
        else {
            g.setColor(new Color(210,180,140));
        }
        if( table[position.getRow()][position.getCol()]!= null) {
            this.add(new ChessMan(gameBoard, new Position(position.getRow(),position.getCol())));
        }
        this.setLocation(this.position.getRow()*this.width, (this.position.getCol()*this.width));
        this.setSize(this.width, this.width);
        g.fillRoundRect(0,0,this.width,this.width,4 ,4);
        if( table[position.getCol()][position.getRow()]!=null) {
            g.setColor(Color.PINK);
            g.fillOval(13, 13, this.width / 2, this.width / 2);
        }
      //  this.setLocation(this.position.getRow()*this.width+35, (this.position.getCol()*this.width+35));
//        g.fillRoundRect(35,35,this.width,this.width);
    }

}
