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
		title = new JLabel("<html><font size=10>�۱�ȭ��</font></html>", JLabel.CENTER);
		
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
		
		takeAccountL = new JLabel("<html><font size=5 style=�����ٸ����>�޴°���</font>", JLabel.CENTER);
		giveAccountL = new JLabel("<html><font size=5 style=�����ٸ���� >�����°���</font>", JLabel.CENTER);
		pwL = new JLabel("<html><font size=5 style=�����ٸ����>��й�ȣ</font>", JLabel.CENTER);
		moneyL = new JLabel("<html><font size=5 style=�����ٸ����>�۱ݾ�</font>", JLabel.CENTER);
		
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
					start.sendChange("error"); //����
				}
				else if(result == 1) {
					start.sendChange("ok"); //����
				}
				else if(result == 2) {
					start.sendChange("error2"); //������ ������ ����
				}
				else if(result == 3) {
					start.sendChange("error3"); //������ ������ �ܾ׺���
				}
				else if(result == 1) {
					start.sendChange("error4"); //�޴� ���°� ������
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
