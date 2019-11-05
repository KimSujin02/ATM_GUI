package bank_gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import jdbc.BankDbBean;

public class Record extends JPanel {
	private Start start;
	
	private GridLayout g1 = new GridLayout(3, 0);
	
	private GridLayout g2 = new GridLayout(2, 2);

	private JPanel recordPanel = new JPanel();
	private JPanel recordPanelButton = new JPanel();
	
	private JLabel accountL;
	private JLabel pwL;
	
	private JTextField accountIn;
	private JTextField pwIn;
	
	private JButton ok;
	private JButton cancle;
	
	private String account_num = "";
	private String pw = "";
	
	public Record(Start start) {
		this.start = start;
		JLabel title = new JLabel("<html><font size=10>³»¿ªÈ®ÀÎ</font></html>", JLabel.CENTER);
		
		OkCancleButton imgButton = new OkCancleButton();

		ok = new JButton(imgButton.okButton_edit);
		ok.setRolloverIcon(imgButton.okButton_edit_1);
		ok.setBorderPainted(false);
		ok.setFocusPainted(false);
		ok.setContentAreaFilled(false);
		
		cancle = new JButton(imgButton.cancleButton_edit);
		cancle.setRolloverIcon(imgButton.cancleButton_edit_1);
		cancle.setBorderPainted(false);
		cancle.setFocusPainted(false);
		cancle.setContentAreaFilled(false);
		
		accountL = new JLabel("<html><font size=5 style=³ª´®¹Ù¸¥°íµñ >°èÁÂ¹øÈ£</font>", JLabel.CENTER);
		pwL = new JLabel("<html><font size=5 style=³ª´®¹Ù¸¥°íµñ>ºñ¹Ð¹øÈ£</font>", JLabel.CENTER);
		
		accountIn = new JTextField("", 20);
		pwIn = new JTextField("", 20);
		
		recordPanel.setLayout(g2);

		recordPanel.add(accountL, JLabel.CENTER_ALIGNMENT);
		recordPanel.add(accountIn, JTextField.CENTER_ALIGNMENT);
		recordPanel.add(pwL, JLabel.CENTER_ALIGNMENT);
		recordPanel.add(pwIn, JTextField.CENTER_ALIGNMENT);
		
		recordPanelButton.add(ok);
		recordPanelButton.add(cancle);
		
		setLayout(g1);
		
		add(title);
		add(recordPanel);
		add(recordPanelButton);
		
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				account_num = accountIn.getText();
				pw = pwIn.getText();
				
				account_num.toString();
				pw.toString();
				
				start.recordCheck(account_num, pw);
			}
		});
		
		cancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				start.mainChange("cancle");
			}
		});
	}
}
