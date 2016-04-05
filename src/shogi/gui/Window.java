package shogi.gui;

import javax.swing.*;
import java.awt.*;

/**
 * @author sina
 * @version 1.0
 * Created by sina on 4/5/16.
 */
public class Window extends JFrame {
    public Window ( ){
        this.setSize(1000,1050);
        this.getContentPane().setBackground(new Color(255,224,200));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        //Window window = new Window();
        GameWindow gameWindow = new GameWindow();
    }
}
