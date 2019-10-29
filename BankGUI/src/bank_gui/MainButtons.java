package bank_gui;

import java.awt.*;

import javax.swing.*;

public class MainButtons extends JFrame {
	FlowLayout f1 = new FlowLayout();
	JPanel buttonsPanel = new JPanel();
	
	JButton create;
	JButton record;
	JButton send;
	JButton deposit;
	JButton withdraw;

	public MainButtons() {
		
		ImageIcon button1 = new ImageIcon(Main.class.getResource("/image/create.png"));
		ImageIcon button1_edit = new ImageIcon(button1.getImage().getScaledInstance(164, 63, Image.SCALE_DEFAULT));

		ImageIcon button2 = new ImageIcon(Main.class.getResource("/image/record.png"));
		ImageIcon button2_edit = new ImageIcon(button2.getImage().getScaledInstance(164, 63, Image.SCALE_DEFAULT));
		
		ImageIcon button3 = new ImageIcon(Main.class.getResource("/image/send.png"));
		ImageIcon button3_edit = new ImageIcon(button3.getImage().getScaledInstance(164, 63, Image.SCALE_DEFAULT));
		
		ImageIcon button4 = new ImageIcon(Main.class.getResource("/image/deposit.png"));
		ImageIcon button4_edit = new ImageIcon(button4.getImage().getScaledInstance(164, 63, Image.SCALE_DEFAULT));
		
		ImageIcon button5 = new ImageIcon(Main.class.getResource("/image/withdraw.png"));
		ImageIcon button5_edit = new ImageIcon(button5.getImage().getScaledInstance(164, 63, Image.SCALE_DEFAULT));
		
		
		ImageIcon button_1= new ImageIcon(Main.class.getResource("/image/create1.png"));
		ImageIcon button_edit1 = new ImageIcon(button_1.getImage().getScaledInstance(164, 63, Image.SCALE_DEFAULT));
		
		ImageIcon button_2= new ImageIcon(Main.class.getResource("/image/record1.png"));
		ImageIcon button_edit2 = new ImageIcon(button_2.getImage().getScaledInstance(164, 63, Image.SCALE_DEFAULT));
		
		ImageIcon button_3= new ImageIcon(Main.class.getResource("/image/send1.png"));
		ImageIcon button_edit3 = new ImageIcon(button_3.getImage().getScaledInstance(164, 63, Image.SCALE_DEFAULT));
		
		ImageIcon button_4= new ImageIcon(Main.class.getResource("/image/deposit1.png"));
		ImageIcon button_edit4 = new ImageIcon(button_4.getImage().getScaledInstance(164, 63, Image.SCALE_DEFAULT));
		
		ImageIcon button_5= new ImageIcon(Main.class.getResource("/image/withdraw1.png"));
		ImageIcon button_edit5 = new ImageIcon(button_5.getImage().getScaledInstance(164, 63, Image.SCALE_DEFAULT));

		create = new JButton(button1_edit);
		record = new JButton(button2_edit);
		send = new JButton(button3_edit);
		deposit = new JButton(button4_edit);
		withdraw = new JButton(button5_edit);
		
		create.setRolloverIcon(button_edit1);
		create.setBorderPainted(false);
		create.setFocusPainted(false);
		create.setContentAreaFilled(false);
		
		record.setRolloverIcon(button_edit2);
		record.setBorderPainted(false);
		record.setFocusPainted(false);
		record.setContentAreaFilled(false);
		
		send.setRolloverIcon(button_edit3);
		send.setBorderPainted(false);
		send.setFocusPainted(false);
		send.setContentAreaFilled(false);
		
		deposit.setRolloverIcon(button_edit4);
		deposit.setBorderPainted(false);
		deposit.setFocusPainted(false);
		deposit.setContentAreaFilled(false);
		
		withdraw.setRolloverIcon(button_edit5);
		withdraw.setBorderPainted(false);
		withdraw.setFocusPainted(false);
		withdraw.setContentAreaFilled(false);
		
		f1.add(buttonsPanel);

		buttonsPanel.add(create);
		buttonsPanel.add(record);
		buttonsPanel.add(send);
		buttonsPanel.add(deposit);
		buttonsPanel.add(withdraw);

		
	}
}
