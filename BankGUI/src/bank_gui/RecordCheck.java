package bank_gui;

import javax.swing.*;

import jdbc.BankDbBean;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecordCheck extends JPanel {
	
	private GridLayout g1;
	
	private Start start;
	
	private JLabel title;

	JTextArea ta1;
	
	private JButton ok;
	
	String record;
	
	public RecordCheck(String account_num, String pw) {
		jdbc.BankDbBean bankDbBean = new BankDbBean();
		record = bankDbBean.CheckRecord(account_num, pw);
	}
	
	public RecordCheck(Start start) {
		this.start = start;
		g1 = new GridLayout(3, 0);
		
		OkCancleButton imgButton = new OkCancleButton();
		
		ok = new JButton(imgButton.okButton_edit);
		ok.setRolloverIcon(imgButton.okButton_edit_1);
		ok.setBorderPainted(false);
		ok.setFocusPainted(false);
		ok.setContentAreaFilled(false);
		
		title = new JLabel("<html><font size=10>내역확인</font></html>", JLabel.CENTER);
		
		ta1 = new JTextArea();
		
		ta1.setText(record);
		
		setLayout(g1);
		
		add(title);
		add(ta1);
		add(ok);
		
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				start.mainChange("ok");
				
			}
		});
	}
}
