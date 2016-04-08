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
        this.setTitle("NEW GAME ");
        whitePlayerList = new IncomingChessMen(IncomingChessMen.roles.PLAYER_BLACK);
        blackPlayerList = new IncomingChessMen(IncomingChessMen.roles.PLAYER_WHITE);
        this.add(blackPlayerList);
        this.add(whitePlayerList);
        this.add(gameMap);

        super.setVisible(true);

    }

    public static void main(String[] args) {
    }

}
