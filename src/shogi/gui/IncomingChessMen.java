package shogi.gui;

import apple.laf.JRSUIConstants;
import shogi.piece.ChessMen;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.text.StringContent;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by sina on 4/5/16.
 */
public class IncomingChessMen extends JPanel {
    private Color whitePlayerBackground = new Color(139,69,19);
    private Color blackPlayerBackground = new Color(210,180,140);
    private ArrayList<ChessMen> pieces = new ArrayList<>();
    protected enum  roles {
        PLAYER_BLACK,PLAYER_WHITE
    }

    public IncomingChessMen(roles role) {
        if(role == roles.PLAYER_WHITE){
            this.setBackground(this.whitePlayerBackground);
            this.setSize(180,630);
            this.setLocation(0,200);
            this.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.white));
            JLabel myLabel = new JLabel("WHITE  BASE!!!");
            myLabel.setFont(myFont());
            myLabel.setForeground(Color.WHITE);
            this.add(myLabel);
        }
        else if ( role == role.PLAYER_BLACK){
            this.setBackground(this.blackPlayerBackground);
            this.setLocation(180+630,200);
            this.setSize(180, 630);
            this.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.black));
            JLabel myLabel = new JLabel("BLACK BASE!!!");
            myLabel.setFont(myFont());
            myLabel.setForeground(Color.BLACK);
            this.add(myLabel);


        }

    }
    private Font myFont(){
        int style = Font.BOLD |  Font.PLAIN;
        Font font = new Font("TimesRoman", style, 20);
        return font ;
    }
    private void push(ChessMen chessMan){
        pieces.add(chessMan);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

    }
}
