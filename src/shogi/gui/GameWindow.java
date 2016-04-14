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
    private  GameBoard gameBoard;



    public GameWindow() {
        super();
        this.setLayout(null);
        this.setTitle("NEW GAME ");
        gameBoard = new GameBoard();

        blackPlayerList = new IncomingChessMen(IncomingChessMen.roles.PLAYER_BLACK, gameBoard);
        whitePlayerList = new IncomingChessMen(IncomingChessMen.roles.PLAYER_WHITE, gameBoard);
        gameMap = new GameMap(gameBoard,whitePlayerList, blackPlayerList);
        blackPlayerList.setGameMap(gameMap);
        whitePlayerList.setGameMap(gameMap);
        this.add(blackPlayerList);
        this.add(whitePlayerList);
        this.add(gameMap);

        super.setVisible(true);

    }

    public static void main(String[] args) {
    }

}
