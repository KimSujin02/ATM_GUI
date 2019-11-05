package bank_gui;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jdbc.BankDbBean;

public class Withdraw extends JPanel {
	private Start start;
	private GridLayout g1 = new GridLayout(3, 0);
	private GridLayout g2 = new GridLayout(3, 2);
	
	private JPanel withdrawPanel = new JPanel();
	private JPanel withdrawPanelButton = new JPanel();
	
	private JLabel account_numL;
	private JLabel pwL;
	private JLabel moneyL;
	
	private JLabel title;
	
	private JTextField account_numIN;
	private JTextField pwIN;
	private JTextField moneyIN;

	private JButton ok;
	private JButton cancle;
	
	private String account_num;
	private String pw;
	private String money;
	
	public Withdraw(Start start) {
		this.start = start;
		title = new JLabel("<html><font size=10>출금화면</font></html>", JLabel.CENTER);
		
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
		pwL = new JLabel("<html><font size=5 style=나눔바른고딕>비밀번호</font>", JLabel.CENTER);
		moneyL = new JLabel("<html><font size=5 style=나눔바른고딕>출금액</font>", JLabel.CENTER);
		
		account_numIN = new JTextField("", 20);
		pwIN = new JTextField("", 20);
		moneyIN = new JTextField("", 20);
		
		withdrawPanel.setLayout(g2);
		
		withdrawPanel.add(account_numL);
		withdrawPanel.add(account_numIN);
		withdrawPanel.add(pwL);
		withdrawPanel.add(pwIN);
		withdrawPanel.add(moneyL);
		withdrawPanel.add(moneyIN);
		
		withdrawPanelButton.add(ok);
		withdrawPanelButton.add(cancle);
		
		setLayout(g1);
		
		add(title);
		add(withdrawPanel);
		add(withdrawPanelButton);
		
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				account_num = account_numIN.getText();
				pw = pwIN.getText();
				money = moneyIN.getText();
				
				account_num.toString();
				pw.toString();
				int moneyOk = Integer.parseInt(money);
				
				int result = bankDbBean.WithDraw(account_num, pw, moneyOk);
				
				if(result == 0) {
					start.withdrawChange("error"); //실패
				}
				else if(result == 1) {
					start.withdrawChange("ok"); //성공
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
