package bank_gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import jdbc.BankDbBean;

public class Send extends JPanel{
	private Start start;
	private GridLayout g1 = new GridLayout(3, 0);
	private GridLayout g2 = new GridLayout(5, 2);
	
	private JPanel sendPanel = new JPanel();
	private JPanel sendPanelButton = new JPanel();
	
	private JLabel title;
	
	private JLabel takeAccountL;
	private JLabel giveAccountL;
	private JLabel pwL;
	private JLabel moneyL;
	
	private JTextField takeAccountIN;
	private JTextField giveAccounyIN;
	private JTextField pwIN;
	private JTextField moneyIN;
	
	private JButton ok;
	private JButton cancle;
	
	private String takeAccount = "";
	private String giveAccount = "";
	private String pw = "";
	private String money = "";
	
	public Send(Start start) {
		this.start = start;
		title = new JLabel("<html><font size=10>송금화면</font></html>", JLabel.CENTER);
		
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
		
		takeAccountL = new JLabel("<html><font size=5 style=나눔바른고딕>받는계좌</font>", JLabel.CENTER);
		giveAccountL = new JLabel("<html><font size=5 style=나눔바른고딕 >보내는계좌</font>", JLabel.CENTER);
		pwL = new JLabel("<html><font size=5 style=나눔바른고딕>비밀번호</font>", JLabel.CENTER);
		moneyL = new JLabel("<html><font size=5 style=나눔바른고딕>송금액</font>", JLabel.CENTER);
		
		takeAccountIN = new JTextField("", 20);
		giveAccounyIN = new JTextField("", 20);
		pwIN = new JTextField("", 20);
		moneyIN = new JTextField("", 20);
		
		sendPanel.setLayout(g2);

		sendPanel.add(takeAccountL);
		sendPanel.add(takeAccountIN);
		sendPanel.add(giveAccountL);
		sendPanel.add(giveAccounyIN);
		sendPanel.add(pwL);
		sendPanel.add(pwIN);
		sendPanel.add(moneyL);
		sendPanel.add(moneyIN);
		
		sendPanelButton.add(ok);
		sendPanelButton.add(cancle);
		
		setLayout(g1);
		
		add(title);
		add(sendPanel);
		add(sendPanelButton);
		
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				takeAccount = takeAccountIN.getText();
				giveAccount = giveAccounyIN.getText();
				pw = pwIN.getText();
				money = moneyIN.getText();
				
				takeAccount.toString();
				giveAccount.toString();
				pw.toString();
				money.toString();
				
				int result = bankDbBean.Send(takeAccount, giveAccount, pw, money);
				
				if(result == 0) {
					start.sendChange("error"); //실패
				}
				else if(result == 1) {
					start.sendChange("ok"); //성공
				}
				else if(result == 2) {
					start.sendChange("error2"); //보내는 계좌의 오류
				}
				else if(result == 3) {
					start.sendChange("error3"); //보내는 계좌의 잔액부족
				}
				else if(result == 1) {
					start.sendChange("error4"); //받는 계좌가 미존재
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
