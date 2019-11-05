package bank_gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import jdbc.BankDbBean;

public class CreateAccount extends JPanel{
	private Start start;
	private GridLayout g1 = new GridLayout(3, 0);
	private GridLayout g2 = new GridLayout(5, 2);
	
	private JPanel createPanel = new JPanel();
	private JPanel createPanelButton = new JPanel();
	
	private JLabel nameL;
	private JLabel accountL;
	private JLabel pwL;
	private JLabel balanceL;
	
	private JTextField nameIn;
	private JTextField accountIn;
	private JTextField pwIn;
	private JTextField balanceIn;
	
	private JButton ok;
	private JButton cancle;
	
	private String name = "";
	private String account_num = "";
	private String pw = "";
	private String balanceIN = "";
	
	public CreateAccount(Start start) {
		this.start = start;
		JLabel title = new JLabel("<html><font size=10>°èÁÂ»ý¼º</font></html>", JLabel.CENTER);
		
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
		
		nameL = new JLabel("<html><font size=5 style=³ª´®¹Ù¸¥°íµñ>ÀÌ¸§</font>", JLabel.CENTER);
		accountL = new JLabel("<html><font size=5 style=³ª´®¹Ù¸¥°íµñ >°èÁÂ¹øÈ£</font>", JLabel.CENTER);
		pwL = new JLabel("<html><font size=5 style=³ª´®¹Ù¸¥°íµñ>ºñ¹Ð¹øÈ£</font>", JLabel.CENTER);
		balanceL = new JLabel("<html><font size=5 style=³ª´®¹Ù¸¥°íµñ>ÀÔ±Ý±Ý¾×</font>", JLabel.CENTER);
		
		nameIn = new JTextField("", 20);
		accountIn = new JTextField("", 20);
		pwIn = new JTextField("", 20);
		balanceIn = new JTextField("", 20);
		
		createPanel.setLayout(g2);

		createPanel.add(nameL);
		createPanel.add(nameIn);
		createPanel.add(accountL);
		createPanel.add(accountIn);
		createPanel.add(pwL);
		createPanel.add(pwIn);
		createPanel.add(balanceL);
		createPanel.add(balanceIn);
		
		createPanelButton.add(ok);
		createPanelButton.add(cancle);
		
		setLayout(g1);
		
		add(title);
		add(createPanel);
		add(createPanelButton);
		
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				name = nameIn.getText();
				account_num = accountIn.getText();
				pw = pwIn.getText();
				balanceIN = balanceIn.getText();
				
				name.toString();
				account_num.toString();
				pw.toString();
				balanceIN.toString();
				
				if(bankDbBean.CreateUser(name, account_num, pw, balanceIN) == 1) {
					start.createChange("ok");
				}
				else if(bankDbBean.CreateUser(name, account_num, pw, balanceIN) == 0) {
					start.createChange("error");
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
