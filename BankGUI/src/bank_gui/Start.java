package bank_gui;

import java.awt.*;
import javax.swing.*;

public class Start extends JFrame{
	Main main;
	CreateAccount createAccount;
	Record record;
	RecordCheck recordCheck;
	Send send;
	Deposit deposit;
	Withdraw withdraw;
	
	public void mainChange(String panelName) {
		
		if(panelName.equals("create")) {
			getContentPane().removeAll();
			getContentPane().add(createAccount);
			revalidate();
			repaint();
		}
		
		else if(panelName.equals("record")) {
			getContentPane().removeAll();
			getContentPane().add(record);
			revalidate();
			repaint();
		}
		
		else if(panelName.equals("send")) {
			getContentPane().removeAll();
			getContentPane().add(send);
			revalidate();
			repaint();
		}
		else if(panelName.equals("deposit")) {
			getContentPane().removeAll();
			getContentPane().add(deposit);
			revalidate();
			repaint();
		}
		else if(panelName.equals("withdraw")) {
			getContentPane().removeAll();
			getContentPane().add(withdraw);
			revalidate();
			repaint();
		}
		
		else if(panelName.equals("ok")) {
			getContentPane().removeAll();
			getContentPane().add(main); //���� ��ȸ �������� �̵�
			revalidate();
			repaint();
		}
		else if(panelName.equals("cancle")) {
	    	getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
        

	}
	
	public void createChange(String panelName) {
		if(panelName.equals("ok")) {
			JOptionPane.showMessageDialog(this, "���»����� �����Ͽ����ϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
		else if(panelName.equals("cancle")) {
        	getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
		else if(panelName.equals("error")) {
			JOptionPane.showMessageDialog(this, "���»����� �����Ͽ����ϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void recordCheck(String account_num, String pw) {
		RecordCheck recordCheck_1 = new RecordCheck(account_num, pw);
		String record = recordCheck_1.record;
		recordCheck.ta1.setText(record);
		getContentPane().removeAll();
		getContentPane().add(recordCheck);
		revalidate();
		repaint();
	}
	
	public void sendChange(String panelName) {
		if(panelName.equals("ok")) {
			JOptionPane.showMessageDialog(this, "�۱��� �����Ͽ����ϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
		else if(panelName.equals("error")) {
			JOptionPane.showMessageDialog(this, "�۱� �����Դϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
		else if(panelName.equals("error2")) {
			JOptionPane.showMessageDialog(this, "������ ���°� �����ͺ��̽��� �������� �ʰų� ��й�ȣ�� Ʋ�Ƚ��ϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
		else if(panelName.equals("error3")) {
			JOptionPane.showMessageDialog(this, "�ܾ׺����Դϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
		else if(panelName.equals("error4")) {
			JOptionPane.showMessageDialog(this, "�޴� ���°� �������� �ʽ��ϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
	}
	
	public void depositChange(String panelName) {
		if(panelName.equals("ok")) {
			JOptionPane.showMessageDialog(this, "�Ա��� �����Ͽ����ϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
		else if(panelName.equals("error")) {
			JOptionPane.showMessageDialog(this, "�Ա� �����Դϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
		
	}
	
	public void withdrawChange(String panelName) {
		if(panelName.equals("ok")) {
			JOptionPane.showMessageDialog(this, "����� �����Ͽ����ϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
		else if(panelName.equals("error")) {
			JOptionPane.showMessageDialog(this, "��� �����Դϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
	}
	
	public static void main(String[] args) {
		Start start = new Start();
		
		start.setTitle("�������� ATM�Դϴ�.");
		start.main = new Main(start);
		start.createAccount = new CreateAccount(start);
		start.record = new Record(start);
		start.recordCheck = new RecordCheck(start);
		start.send = new Send(start);
		start.deposit = new Deposit(start);
		start.withdraw = new Withdraw(start);
		
		start.add(start.main);
		
		start.setPreferredSize(new Dimension(800, 600));
		start.setLocation(500, 200);
		start.setVisible(true);
		start.pack();
		start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
