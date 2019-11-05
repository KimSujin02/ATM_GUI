package bank_gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import jdbc.BankDbBean;

public class Deposit extends JPanel {
	private Start start;
	private GridLayout g1 = new GridLayout(3, 0);
	private GridLayout g2 = new GridLayout(3, 2);
	
	private JPanel depositPanel = new JPanel();
	private JPanel depositPanelButton = new JPanel();
	
	private JLabel account_numL;
	private JLabel moneyL;
	
	private JLabel title;
	
	private JTextField account_numIN;
	private JTextField moneyIN;

	private JButton ok;
	private JButton cancle;
	
	private String account_num;
	private String money;
	
	public Deposit(Start start) {
		this.start = start;
		title = new JLabel("<html><font size=10>입금화면</font></html>", JLabel.CENTER);
		
		jdbc.BankDbBean bankDbBean = new BankDbBean();
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
		
		account_numL = new JLabel("<html><font size=5 style=나눔바른고딕>계좌번호</font>", JLabel.CENTER);
		moneyL = new JLabel("<html><font size=5 style=나눔바른고딕>입금액</font>", JLabel.CENTER);
		
		account_numIN = new JTextField("", 20);
		moneyIN = new JTextField("", 20);
		
		depositPanel.setLayout(g2);
		
		depositPanel.add(account_numL);
		depositPanel.add(account_numIN);
		depositPanel.add(moneyL);
		depositPanel.add(moneyIN);
		
		depositPanelButton.add(ok);
		depositPanelButton.add(cancle);
		
		setLayout(g1);
		
		add(title);
		add(depositPanel);
		add(depositPanelButton);
		
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				account_num = account_numIN.getText();
				money = moneyIN.getText();
				
				account_num.toString();
				int moneyOk = Integer.parseInt(money);
				
				int result = bankDbBean.Deposit(account_num, moneyOk);
				
				if(result == 0) {
					start.depositChange("error"); //실패
				}
				else if(result == 1) {
					start.depositChange("ok"); //성공
				}
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