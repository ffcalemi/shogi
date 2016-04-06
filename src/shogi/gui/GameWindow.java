package shogi.gui;

import shogi.board.GameBoard;
import shogi.board.Position;

import javax.swing.*;
import java.awt.*;

/**
 * @author sina
 * @version 1.0
 * Created by sina on 4/5/16.
 */
public class GameWindow extends Window {//TODO  parivate Menu menu;
    private GameMap gameMap;
     private IncomingChessMen whitePlayerList;
    private IncomingChessMen blackPlayerList;



    public GameWindow() {
        super();
        this.setLayout(null);
        this.add(gameMap = new GameMap(new GameBoard()));
        whitePlayerList = new IncomingChessMen();
        blackPlayerList = new IncomingChessMen();
        whitePlayerList.setLocation(0,200);
        blackPlayerList.setLocation((1000-640)/2+630,200);
        whitePlayerList.setSize((1000-640)/2,630);
        blackPlayerList.setSize((1000-640)/2,630);
          this.add(blackPlayerList);
        this.add(whitePlayerList);
        this.add(gameMap);

        super.setVisible(true);

    }

    public static void main(String[] args) {
    }

}
