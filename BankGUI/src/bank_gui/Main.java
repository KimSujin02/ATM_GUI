package bank_gui;

import java.awt.*;
import javax.swing.*;

public class Main{

    public static void main(String[] args) {
    	BorderLayout b1 = new BorderLayout();
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(b1);
        

        frame.add(panel);

        frame.setPreferredSize(new Dimension(600, 400));
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
