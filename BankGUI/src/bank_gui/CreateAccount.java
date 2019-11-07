package bank_gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import jdbc.BankDbBean;

public class CreateAccount extends JPanel{
	private Start start;
	private GridLayout g1 = new GridLayout(3, 0); //title�� �Է�ĭ ��ư ������ ����
	private GridLayout g2 = new GridLayout(5, 2); //�Է�ĭ? Lable��� TextField���� �����ϱ� ����
	
	private JPanel createPanel = new JPanel(); //�Է�ĭ���� �׷����� ���� ���� �г�
	private JPanel createPanelButton = new JPanel(); //��ư���� �������� �г�
	
	private JLabel nameL; //�̸�
	private JLabel accountL; //����
	private JLabel pwL; //���
	private JLabel balanceL; //�Աݱݾ�
	
	private JTextField nameIn; //�̸��Է�
	private JTextField accountIn; //���¹�ȣ �Է�
	private JTextField pwIn; //����Է�
	private JTextField balanceIn; //�ݾ��Է�
	
	private JButton ok; //���»��� ok��ư
	private JButton cancle; //��ҹ�ư. ������ mainȭ������ �г��� ��ȯ�ȴ�.
	
	private String name = ""; //�Է¹��� ���� String ������ ��ȯ�ϰ� ������ ���̽��� �ֱ� ���� ���� ������..~
	private String account_num = "";
	private String pw = "";
	private String balanceIN = "";
	
	public CreateAccount(Start start) {
		this.start = start;
		JLabel title = new JLabel("<html><font size=10>���»���</font></html>", JLabel.CENTER);
		
		jdbc.BankDbBean bankDbBean = new BankDbBean();
		OkCancleButton imgButton = new OkCancleButton();
		
		ok = new JButton(imgButton.okButton_edit);
		ok.setRolloverIcon(imgButton.okButton_edit_1); //���콺�� ��ư�� ������ ��� ��ư�� ��� ���ϴ� ��..
		ok.setBorderPainted(false);
		ok.setFocusPainted(false);
		ok.setContentAreaFilled(false);
		
		cancle = new JButton(imgButton.cancleButton_edit);
		cancle.setRolloverIcon(imgButton.cancleButton_edit_1);
		cancle.setBorderPainted(false);
		cancle.setFocusPainted(false);
		cancle.setContentAreaFilled(false);
		
		nameL = new JLabel("<html><font size=5 style=�����ٸ����>�̸�</font>", JLabel.CENTER);
		accountL = new JLabel("<html><font size=5 style=�����ٸ���� >���¹�ȣ</font>", JLabel.CENTER);
		pwL = new JLabel("<html><font size=5 style=�����ٸ����>��й�ȣ</font>", JLabel.CENTER);
		balanceL = new JLabel("<html><font size=5 style=�����ٸ����>�Աݱݾ�</font>", JLabel.CENTER);
		
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
				
				//�Է¹��� ���� String���� �ٲ�
				//�ٲ�� DB�� �����ϴ� Ŭ������ �޼ҵ�鿡 ���� ���� �� ����.
				name = nameIn.getText();
				account_num = accountIn.getText();
				pw = pwIn.getText();
				balanceIN = balanceIn.getText();
				
				name.toString();
				account_num.toString();
				pw.toString();
				balanceIN.toString();
				
				//�Է¹��� ������ DbBeanŬ������ �ִ� ���»����ϴ� �޼ҵ�� ������ ���¸� �����Ѵ�.
				//������ �����ϸ� 1�� ��µ�. ��µǸ� �����ߴٴ� â?�� ���� �ϴ� �޼ҵ�� ������.
				if(bankDbBean.CreateUser(name, account_num, pw, balanceIN) == 1) {
					start.createChange("ok");
				}
				//�����ϸ� ���� â�� �߰� �ϴ� �޼ҵ�� ������.
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
