package shogi.gui;

import shogi.board.GameBoard;
import shogi.board.Position;
import shogi.piece.ChessMen;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.text.StringContent;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
// you can add 3 in each row

/**
 * Created by sina on 4/5/16.
 */
public class IncomingChessMen extends JPanel {
    private Color whitePlayerBackground = new Color(139, 69, 19);
    private Color blackPlayerBackground = new Color(210, 180, 140);
    private ArrayList<ChessMen> pieces = new ArrayList<>();
    private ChessMen kickedChessman;
    private GameBoard gameBoard;
    private ChessMen add;
    private ArrayList<Position> putable = new ArrayList<>();
    private  GameMap gameMap;

    public void setPutable(ArrayList<Position> putable) {
        this.putable = putable;
    }

    public ArrayList<Position> getPutable() {

        return putable;
    }

    public ChessMen getAddToMapChessMan() {
        return addToMapChessMan;
    }

    private ChessMen addToMapChessMan;

    protected enum roles {
        PLAYER_BLACK, PLAYER_WHITE
    }

    private roles role;

    public IncomingChessMen(roles role, GameBoard gameBoard ) {
        this.role = role;
        this.gameBoard = gameBoard;
        if (role == roles.PLAYER_WHITE) {

            this.setBackground(this.whitePlayerBackground);
            this.setSize(180, 630);
            this.setLocation(180 + 630, 200);

            this.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.white));
            JLabel myLabel = new JLabel("WHITE  BASE!!!");
            myLabel.setFont(myFont());
            myLabel.setForeground(Color.WHITE);
            this.add(myLabel);
        } else if (role == role.PLAYER_BLACK) {
            this.setBackground(this.blackPlayerBackground);
            this.setLocation(0, 200);

            this.setSize(180, 630);
            this.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.black));
            JLabel myLabel = new JLabel("BLACK BASE!!!");
            myLabel.setFont(myFont());
            myLabel.setForeground(Color.BLACK);
            this.add(myLabel);
            MyMouselistener ml = new MyMouselistener(this.pieces, gameBoard);
            this.addMouseListener(ml);
            this.pieces = ml.getPieces();
            repaint();

        }

    }
    public void setGameMap(GameMap gameMap){
        this.gameMap = gameMap;

    }

    private Font myFont() {
        int style = Font.BOLD | Font.PLAIN;
        Font font = new Font("TimesRoman", style, 20);
        return font;
    }

    private Character gettingSignOfChessMen(ChessMen chess) {
        Character ch;
        if (chess.getClass().getSimpleName().compareTo("SilverGeneral") == 0) {
            ch = 's';
            return ch;
        } else if (chess.getClass().getSimpleName().compareTo("Knight") == 0) {
            ch = 'N';
            return ch;
        } else {
            ch = chess.getClass().getSimpleName().charAt(0);
        }
        return ch;
    }

    private void showingPutable(ArrayList<Position> a) {
        for (int i = 0; i < a.size(); i++) {
            int n = a.get(i).getRow() * 9 + a.get(i).getCol();
            Cell c = GameMap.cells.get(n);
            c.setBackground(c.getCorrectColor());
        }


    }

    private int findingX(int index) {
        int x;
        x = index % 3;
        return x;
    }

    private int findingY(int index) {
        int y;
        y = index / 3;
        return (y * 60) + 20;
    }

    public void setAddToMapChessMan(ChessMen addToMapChessMan) {
        this.addToMapChessMan = addToMapChessMan;
    }

    protected void push(ChessMen chessMan) {
        pieces.add(chessMan);
        kickedChessman = chessMan;
        repaint();

    }

    //TODO handle : pop()
    protected void pop(ArrayList<ChessMen> ch) {
        if (this.role == roles.PLAYER_WHITE) {
            MyMouselistener ml = new MyMouselistener(this.pieces, gameBoard);
            this.addMouseListener(ml);
            //   this.addMouseListener (new MyMouselistener(this.pieces));
            this.pieces = ch;
            repaint();


        } else {
            MyMouselistener ml = new MyMouselistener(this.pieces, gameBoard);
            this.addMouseListener(ml);
            //   this.addMouseListener (new MyMouselistener(this.pieces));
            this.pieces = ch;
            repaint();


        }

    }

    private void chessManDrawer(Graphics g, ChessMen ch) {
        if (ch != null) {
            if (ch.getPlayerRole() == ChessMen.roles.PLAYER_WHITE_ROLE) {
                g.setColor(Color.white);
                int[] x = new int[5];
                int[] y = new int[5];

                x[0] = 35 + findingX(pieces.indexOf(ch)) * 55;
                y[0] = 5 + findingY(pieces.indexOf(ch));
                x[1] = 60 + findingX(pieces.indexOf(ch)) * 55;
                y[1] = 20 + findingY(pieces.indexOf(ch));
                x[2] = 60 + findingX(pieces.indexOf(ch)) * 55;
                y[2] = 60 + findingY(pieces.indexOf(ch));
                x[3] = 10 + findingX(pieces.indexOf(ch)) * 55;
                y[3] = 60 + findingY(pieces.indexOf(ch));
                x[4] = 10 + findingX(pieces.indexOf(ch)) * 55;
                y[4] = 20 + findingY(pieces.indexOf(ch));

                g.fillPolygon(x, y, 5);
                g.setColor(Color.BLACK);
                int style = Font.BOLD | Font.PLAIN;
                Font font = new Font("TimesRoman", style, 20);
                g.setFont(font);
                g.drawString(this.gettingSignOfChessMen(ch).toString().toUpperCase(), x[0] - 3, y[0] + 35);


            } else if (ch.getPlayerRole() == ChessMen.roles.PLAYER_BLACK_ROLE) {
                g.setColor(Color.black);
                int[] x = new int[5];
                int[] y = new int[5];

                x[0] = 35 + findingX(pieces.indexOf(ch)) * 55;
                System.out.println("x[0] is " + x[0]);
                y[0] = 5 + findingY(pieces.indexOf(ch));
                x[1] = 60 + findingX(pieces.indexOf(ch)) * 55;
                y[1] = 20 + findingY(pieces.indexOf(ch));
                x[2] = 60 + findingX(pieces.indexOf(ch)) * 55;
                y[2] = 60 + findingY(pieces.indexOf(ch));
                x[3] = 10 + findingX(pieces.indexOf(ch)) * 55;
                y[3] = 60 + findingY(pieces.indexOf(ch));
                x[4] = 10 + findingX(pieces.indexOf(ch)) * 55;
                y[4] = 20 + findingY(pieces.indexOf(ch));

                g.fillPolygon(x, y, 5);

                g.setColor(Color.white);
                int style = Font.BOLD | Font.PLAIN;
                Font font = new Font("TimesRoman", style, 20);

                g.setFont(font);
                g.drawString(this.gettingSignOfChessMen(ch).toString().toUpperCase(), x[0] - 3, y[0] + 35);


            }
        }
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        ChessMen c;
        for (int i = 0; i < pieces.size(); i++) {

            this.chessManDrawer(g, pieces.get(i));
        }

    }

    class MyMouselistener implements MouseListener {


        public ArrayList<ChessMen> getPieces() {
            return pieces;
        }

        private IncomingChessMen ic;
        private GameBoard gameBoard;
        private ChessMen tempChessman;

        private ArrayList<ChessMen> pieces = new ArrayList<>();

        public MyMouselistener(ArrayList<ChessMen> pieces, GameBoard gameBoard) {

            this.pieces = pieces;
            this.gameBoard = gameBoard;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            int index;
            index = this.findingIndex(e);
            if (index != -1) {
                add = gameBoard.getBlackKickedPieceIndex(index);
                if (role == roles.PLAYER_WHITE) {
                    gameMap.paintingCells(gameBoard.calculatingPuts(add));
                }
                else {
                    gameMap.paintingCells(gameBoard.calculatingPuts(add));
                }

            }
//           ic.setAddToMapChessMan(this.pieces.get(index)) ;
//        this.pieces.remove(index);
//        ic.pop(this.pieces);


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

        private int findingIndex(MouseEvent e) {
            int x, y;
            x = -1;
            int index;
            if (e.getX() < 5) ;
            else if (e.getX() <= 60)
                x = 0;
            else if (e.getX() <= 55 + 60)
                x = 1;
            else if (e.getX() <= 170)
                x = 2;
            else if (e.getX() > 170) ;
            y = (e.getY() - 20) / 55;
            index = y * 3 + x;
            if (x == -1)
                return -1;
            if (index >= pieces.size())
                return -1;
            else return index;

        }
    }

}



