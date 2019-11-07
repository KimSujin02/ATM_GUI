//2306 ������� ������Ʈ BankGUI
//
//[���� ���]
//src > bank_gui > Start.java ���� ��������ּ���
//
//[������ ���α׷� ����]
//������ ���̽��� ���¸� �����ϰ� ������ ���̽��� ��ȿ�� ���µ� ���̿��� �۱��� �����ϰ�, ���»��� �Ա� �۱� ����� �� �� ���� �ش� ���¿� ������ �ܾ��� �߰��Ͽ� ���³��� ��ȸȭ�鿡�� �ش� ������ ������ �ܾ��� Ȯ���� �� �ִ�.
//
//�������� ���̵� ������ Ȯ�� �� �� �ִ� ���α׷�.

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
		
		//���»��� �гη� ��ȯ
		if(panelName.equals("create")) {
			getContentPane().removeAll();
			getContentPane().add(createAccount);
			revalidate();
			repaint();
		}
		//������ȸ �гη� ��ȯ
		else if(panelName.equals("record")) {
			getContentPane().removeAll();
			getContentPane().add(record);
			revalidate();
			repaint();
		}
		//�۱� �гη� ��ȯ
		else if(panelName.equals("send")) {
			getContentPane().removeAll();
			getContentPane().add(send);
			revalidate();
			repaint();
		}
		//�Ա� �гη� ��ȯ
		else if(panelName.equals("deposit")) {
			getContentPane().removeAll();
			getContentPane().add(deposit);
			revalidate();
			repaint();
		}
		//��� �гη� ��ȯ
		else if(panelName.equals("withdraw")) {
			getContentPane().removeAll();
			getContentPane().add(withdraw);
			revalidate();
			repaint();
		}
		//Ȯ�� ��ư�� ������ �ٽ� mainȭ������ ��ȯ
		else if(panelName.equals("ok")) {
			getContentPane().removeAll();
			getContentPane().add(main); //���� ��ȸ �������� �̵�
			revalidate();
			repaint();
		}
		//��� ��ư�� ������ mainȭ������ ��ȯ
		else if(panelName.equals("cancle")) {
	    	getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
        

	}
	//���»��� ȭ�鿡�� ��ư�� ���� �ÿ� �Ͼ�� �̺�Ʈ??
	public void createChange(String panelName) {
		//Ȯ�� ��ư�� ������ DBŬ������ ����Ͽ� ���� ���� ���� �����ϸ� ���� â�� ����.
		//â���� Ȯ���� ������ ����ȭ������ �Ѿ��.
		if(panelName.equals("ok")) {
			JOptionPane.showMessageDialog(this, "���»����� �����Ͽ����ϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
		//��� ��ư�� ������ ���»����� ��ҵǰ� ����ȭ������ ��ȯ�ȴ�.
		else if(panelName.equals("cancle")) {
        	getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
		//DBŬ������ �̿��ؼ� ���� ������ ���̽��� �ִ� ���� �����ϸ� ȭ���� �Ѿ�� �ʰ� �Է��� ���� ��Ȯ���� Ȯ���� �� �ְ� ���ش�.
		else if(panelName.equals("error")) {
			JOptionPane.showMessageDialog(this, "���»����� �����Ͽ����ϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//������ȸ ȭ������ ��ȯ�ϴ� �޼ҵ�
	//������ȸ ȭ�鿡�� �� �޼ҵ带 ȣ���ϸ� �Է¹��� ���¿� ��й�ȣ�� ���°� ��ȿ���� Ȯ���ϰ� �� ������ ������ �ҷ��´�.
	//�ҷ��� ������ ����Ȯ�� ȭ������ ������ Ȯ���ϴ� ȭ���� �����ش�.
	public void recordCheck(String account_num, String pw) {
		RecordCheck recordCheck_1 = new RecordCheck(account_num, pw);
		String record = recordCheck_1.record;
		recordCheck.ta1.setText(record);
		getContentPane().removeAll();
		getContentPane().add(recordCheck);
		revalidate();
		repaint();
	}
	
	//�۱�ȭ�鿡�� �Է¹��� ���� ������ ���̽��� �ְ� ���� ���� ���θ� â���� �� �����ش�.
	public void sendChange(String panelName) {
		//�۱��� �����ϸ� â�� ������� Ȯ���� ������ �ٽ� mainȭ������ ��ȯ�ȴ�.
		if(panelName.equals("ok")) {
			JOptionPane.showMessageDialog(this, "�۱��� �����Ͽ����ϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
		//�۱� �����ͺ��̽��� ���� ������ �������� ������ ���� ��, ���� â�� ���� ���� ȭ������ ��ȯ�ȴ�.
		else if(panelName.equals("error")) {
			JOptionPane.showMessageDialog(this, "�۱� �����Դϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
		//DBŬ���������� ������ ���� 2�� �����̸� �Ʒ� â�� ���� Ȯ���� ������ �������� �Ѿ��.
		else if(panelName.equals("error2")) {
			JOptionPane.showMessageDialog(this, "������ ���°� �����ͺ��̽��� �������� �ʰų� ��й�ȣ�� Ʋ�Ƚ��ϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
		//�ܾ׺��� ������ �߸� �Ʒ��� â�� ���� ����ȭ������ �Ѿ��.
		else if(panelName.equals("error3")) {
			JOptionPane.showMessageDialog(this, "�ܾ׺����Դϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
		//�ݾ��� �޴� ���°� �����ͺ��̽��� �������� ������ �Ʒ��� â�� ���� Ȯ���� ������ ����ȭ������ �Ѿ��.
		else if(panelName.equals("error4")) {
			JOptionPane.showMessageDialog(this, "�޴� ���°� �������� �ʽ��ϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
	}
	
	//�Ա�ȭ�鿡���� â
	public void depositChange(String panelName) {
		//�����ͺ��̽��� ��ȿ�� ���¿� �Ա��� �����ϸ� â�� ���� Ȯ���� ������ ����ȭ������ ��ȯ�ȴ�.
		if(panelName.equals("ok")) {
			JOptionPane.showMessageDialog(this, "�Ա��� �����Ͽ����ϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
		//������ ���̽��� �Ա��� ���еȴٸ� ����â�� ���� Ȯ���� ������ ����ȭ������ �Ѿ��.
		else if(panelName.equals("error")) {
			JOptionPane.showMessageDialog(this, "�Ա� �����Դϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
		
	}
	
	public void withdrawChange(String panelName) {
		//����� �����ϸ� �Ʒ��� â�� ���
		if(panelName.equals("ok")) {
			JOptionPane.showMessageDialog(this, "����� �����Ͽ����ϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
		//�����ϸ� ������� â
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
		
		//start��� JFrame�� ��ӹ��� Ŭ������ main�̶�� JPanel�� ��ӹ��� Ŭ������ add�Ѵ�.
		//frame���� mainȭ���� ����.
		start.add(start.main);
		
		start.setPreferredSize(new Dimension(800, 600));
		start.setLocation(500, 200);
		start.setVisible(true);
		start.pack();
		start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
