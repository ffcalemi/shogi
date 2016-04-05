package shogi.gui;

import shogi.board.GameBoard;
import shogi.board.Position;
import shogi.piece.ChessMen;

import javax.swing.*;
import java.awt.*;

/**
 * @author sina
 * @version 1.0
 * Created by sina on 4/5/16.
 */
public class ChessMan extends JPanel {
  private   Position position;
    private ChessMen[][] table;// = new ChessMen[9][9];
    public ChessMan(GameBoard gameBoard ,Position pos ) {
        this.table = gameBoard.getTable();
        this.position=pos;
    }
    public void  paint(Graphics g){
        this.setSize(30,30);
        this.setLocation(this.position.getRow()*70+35, (this.position.getCol()*70+35));
        g.setColor(Color.green);
        g.fillOval(0,0,30,30);

    }

}
