//2306 김수진의 프로젝트 BankGUI
//
//[실행 방법]
//src > bank_gui > Start.java 파일 실행시켜주세요
//
//[간단한 프로그램 설명]
//데이터 베이스에 계좌를 생성하고 데이터 베이스에 유효한 계좌들 사이에서 송금이 가능하고, 계좌생성 입금 송금 출금을 할 때 마다 해당 계좌에 내역과 잔액을 추가하여 계좌내역 조회화면에서 해당 계좌의 내역과 잔액을 확인할 수 있다.
//
//종이통장 없이도 내역을 확인 할 수 있는 프로그램.

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
		
		//계좌생성 패널로 전환
		if(panelName.equals("create")) {
			getContentPane().removeAll();
			getContentPane().add(createAccount);
			revalidate();
			repaint();
		}
		//내역조회 패널로 전환
		else if(panelName.equals("record")) {
			getContentPane().removeAll();
			getContentPane().add(record);
			revalidate();
			repaint();
		}
		//송금 패널로 전환
		else if(panelName.equals("send")) {
			getContentPane().removeAll();
			getContentPane().add(send);
			revalidate();
			repaint();
		}
		//입금 패널로 전환
		else if(panelName.equals("deposit")) {
			getContentPane().removeAll();
			getContentPane().add(deposit);
			revalidate();
			repaint();
		}
		//출금 패널로 전환
		else if(panelName.equals("withdraw")) {
			getContentPane().removeAll();
			getContentPane().add(withdraw);
			revalidate();
			repaint();
		}
		//확인 버튼을 누르면 다시 main화면으로 전환
		else if(panelName.equals("ok")) {
			getContentPane().removeAll();
			getContentPane().add(main); //내역 조회 페이지로 이동
			revalidate();
			repaint();
		}
		//취소 버튼을 누르면 main화면으로 전환
		else if(panelName.equals("cancle")) {
	    	getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
        

	}
	//계좌생성 화면에서 버튼을 누를 시에 일어나는 이벤트??
	public void createChange(String panelName) {
		//확인 버튼을 누르고 DB클래스를 사용하여 값을 넣은 것이 성공하면 작은 창을 띄운다.
		//창에서 확인을 누르면 메인화면으로 넘어간다.
		if(panelName.equals("ok")) {
			JOptionPane.showMessageDialog(this, "계좌생성이 성공하였습니다.", "성공", JOptionPane.INFORMATION_MESSAGE);
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
		//취소 버튼을 누르면 계좌생성이 취소되고 메인화면으로 전환된다.
		else if(panelName.equals("cancle")) {
        	getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
		//DB클래스를 이용해서 값을 데이터 베이스에 넣는 것을 실패하면 화면이 넘어가지 않고 입력한 값이 정확한지 확인할 수 있게 해준다.
		else if(panelName.equals("error")) {
			JOptionPane.showMessageDialog(this, "계좌생성이 실패하였습니다.", "실패", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//내역조회 화면으로 전환하는 메소드
	//내역조회 화면에서 이 메소드를 호출하면 입력받은 계좌와 비밀번호로 계좌가 유효한지 확인하고 그 계좌의 내역을 불러온다.
	//불러온 내역을 내역확인 화면으로 보내서 확인하는 화면을 보여준다.
	public void recordCheck(String account_num, String pw) {
		RecordCheck recordCheck_1 = new RecordCheck(account_num, pw);
		String record = recordCheck_1.record;
		recordCheck.ta1.setText(record);
		getContentPane().removeAll();
		getContentPane().add(recordCheck);
		revalidate();
		repaint();
	}
	
	//송금화면에서 입력받은 값을 데이터 베이스에 넣고 성공 실패 여부를 창으로 띄어서 보여준다.
	public void sendChange(String panelName) {
		//송금이 성공하면 창이 띄어지고 확인을 누르면 다시 main화면으로 전환된다.
		if(panelName.equals("ok")) {
			JOptionPane.showMessageDialog(this, "송금을 성공하였습니다.", "성공", JOptionPane.INFORMATION_MESSAGE);
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
		//송금 데이터베이스에 값을 보내는 과정에서 에러가 생길 시, 실패 창을 띄우고 메인 화면으로 전환된다.
		else if(panelName.equals("error")) {
			JOptionPane.showMessageDialog(this, "송금 실패입니다.", "실패", JOptionPane.INFORMATION_MESSAGE);
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
		//DB클래스에서의 걀과의 값이 2번 에러이면 아래 창을 띄우고 확인을 누르면 메인으로 넘어간다.
		else if(panelName.equals("error2")) {
			JOptionPane.showMessageDialog(this, "보내는 계좌가 데이터베이스에 존재하지 않거나 비밀번호가 틀렸습니다.", "실패", JOptionPane.INFORMATION_MESSAGE);
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
		//잔액부족 에러가 뜨면 아래의 창을 띄우고 메인화면으로 넘어간다.
		else if(panelName.equals("error3")) {
			JOptionPane.showMessageDialog(this, "잔액부족입니다.", "실패", JOptionPane.INFORMATION_MESSAGE);
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
		//금액을 받는 계좌가 데이터베이스에 존재하지 않으면 아래의 창을 띄우고 확인을 누르면 메인화면으로 넘어간다.
		else if(panelName.equals("error4")) {
			JOptionPane.showMessageDialog(this, "받는 계좌가 존재하지 않습니다.", "실패", JOptionPane.INFORMATION_MESSAGE);
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
	}
	
	//입금화면에서의 창
	public void depositChange(String panelName) {
		//데이터베이스에 유효한 계좌에 입금을 성공하면 창을 띄우고 확인을 누르면 메인화면으로 전환된다.
		if(panelName.equals("ok")) {
			JOptionPane.showMessageDialog(this, "입금을 성공하였습니다.", "성공", JOptionPane.INFORMATION_MESSAGE);
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
		//데이터 베이스에 입금이 실패된다면 에러창을 띄우고 확인을 누르면 메인화면으로 넘어간다.
		else if(panelName.equals("error")) {
			JOptionPane.showMessageDialog(this, "입금 실패입니다.", "실패", JOptionPane.INFORMATION_MESSAGE);
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
		
	}
	
	public void withdrawChange(String panelName) {
		//출금을 성공하면 아래의 창을 띄움
		if(panelName.equals("ok")) {
			JOptionPane.showMessageDialog(this, "출금을 성공하였습니다.", "성공", JOptionPane.INFORMATION_MESSAGE);
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
		//실패하면 띄어지는 창
		else if(panelName.equals("error")) {
			JOptionPane.showMessageDialog(this, "출금 실패입니다.", "실패", JOptionPane.INFORMATION_MESSAGE);
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
		}
	}
	
	public static void main(String[] args) {
		Start start = new Start();
		
		start.setTitle("수진은행 ATM입니다.");
		start.main = new Main(start);
		start.createAccount = new CreateAccount(start);
		start.record = new Record(start);
		start.recordCheck = new RecordCheck(start);
		start.send = new Send(start);
		start.deposit = new Deposit(start);
		start.withdraw = new Withdraw(start);
		
		//start라는 JFrame을 상속받은 클래스에 main이라는 JPanel을 상속받은 클래스를 add한다.
		//frame에는 main화면이 나옴.
		start.add(start.main);
		
		start.setPreferredSize(new Dimension(800, 600));
		start.setLocation(500, 200);
		start.setVisible(true);
		start.pack();
		start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
