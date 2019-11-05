package bank_gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main extends JPanel{
	private Start start;
	
	public Main(Start start) {
		this.start = start;
		
		GridLayout g1 = new GridLayout(2, 0);
		
		MainButtons mb = new MainButtons();

		ImageIcon main = new ImageIcon(Main.class.getResource("/image/mainImage.png"));
		ImageIcon main_edit = new ImageIcon(main.getImage().getScaledInstance(503, 192, Image.SCALE_DEFAULT));
		
		JLabel mainImage = new JLabel(main_edit);
		
		setLayout(g1);
		
		add(mainImage);
		add(mb.buttonsPanel);
		
		mb.create.addActionListener(new createListener());
		mb.record.addActionListener(new recordListener());
		mb.send.addActionListener(new sendListener());
		mb.deposit.addActionListener(new depositListener());
		mb.withdraw.addActionListener(new withdrawListener());
		
	}
	class createListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			start.mainChange("create");
		}
	}
	class recordListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			start.mainChange("record");
		}
	}
	class sendListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			start.mainChange("send");
		}
	}
	class depositListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			start.mainChange("deposit");
		}
	}
	class withdrawListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			start.mainChange("withdraw");
		}
	}
}
