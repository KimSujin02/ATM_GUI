package bank_gui;

import java.awt.*;
import javax.swing.*;

public class Main{
	public Main() {
		JFrame frame = new JFrame("수진은행 ATM입니다.");
		
		GridLayout g1 = new GridLayout(2, 0);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(g1);
		
		MainButtons mb = new MainButtons();

		ImageIcon main = new ImageIcon(Main.class.getResource("/image/mainImage.png"));
		ImageIcon main_edit = new ImageIcon(main.getImage().getScaledInstance(503, 192, Image.SCALE_DEFAULT));
		
		JLabel mainImage = new JLabel(main_edit);
		
		panel1.add(mainImage);
		panel1.add(mb.buttonsPanel);
		
		frame.add(panel1);
		
		frame.setPreferredSize(new Dimension(800, 600));
		frame.setLocation(500, 200);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
    public static void main(String[] args) {
    	new Main();
    }
}