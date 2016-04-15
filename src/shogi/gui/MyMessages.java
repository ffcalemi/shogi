package shogi.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sina on 4/14/16.
 */
public class MyMessages {
    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    private int result= -1;
    public MyMessages(int k) {
        if( k==1) {
            JOptionPane pane = new JOptionPane("Do you want to upgreade?");
            Object[] options = new String[]{"YES", "NO"};
            pane.setOptions(options);
            JDialog dialog = pane.createDialog(new JFrame(), "Upgrade Choice");
            dialog.show();
            Object obj = pane.getValue();
            result = -1;
            for (int i = 0; i < options.length; i++) {
                if (options[i].equals(obj))
                    result = i;
            }
        }else if( k==2){
            JOptionPane pane = new JOptionPane("You must upgrade");
            Object[] options = new String[]{"OK"};
            pane.setOptions(options);
            JDialog dialog = pane.createDialog(new JFrame(), "Upgrade Choice");
            dialog.show();
            Object obj = pane.getValue();
            result = -1;
            for (int i = 0; i < options.length; i++) {
                if (options[i].equals(obj))
                    result = i;
            }

        }



    }
}
