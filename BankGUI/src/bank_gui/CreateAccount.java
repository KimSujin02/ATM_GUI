package bank_gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import jdbc.BankDbBean;

public class CreateAccount extends JPanel{
	private Start start;
	private GridLayout g1 = new GridLayout(3, 0); //title과 입력칸 버튼 순으로 정렬
	private GridLayout g2 = new GridLayout(5, 2); //입력칸? Lable들과 TextField들을 정렬하기 위함
	
	private JPanel createPanel = new JPanel(); //입력칸들을 그룹으로 묶기 위한 패널
	private JPanel createPanelButton = new JPanel(); //버튼들을 묶기위한 패널
	
	private JLabel nameL; //이름
	private JLabel accountL; //계좌
	private JLabel pwL; //비번
	private JLabel balanceL; //입금금액
	
	private JTextField nameIn; //이름입력
	private JTextField accountIn; //계좌번호 입력
	private JTextField pwIn; //비번입력
	private JTextField balanceIn; //금액입력
	
	private JButton ok; //계좌생성 ok버튼
	private JButton cancle; //취소버튼. 누르면 main화면으로 패널이 전환된다.
	
	private String name = ""; //입력받은 값을 String 값으로 변환하고 데이터 베이스에 넣기 위해 만든 변수들..~
	private String account_num = "";
	private String pw = "";
	private String balanceIN = "";
	
	public CreateAccount(Start start) {
		this.start = start;
		JLabel title = new JLabel("<html><font size=10>계좌생성</font></html>", JLabel.CENTER);
		
		jdbc.BankDbBean bankDbBean = new BankDbBean();
		OkCancleButton imgButton = new OkCancleButton();
		
		ok = new JButton(imgButton.okButton_edit);
		ok.setRolloverIcon(imgButton.okButton_edit_1); //마우스를 버튼에 가져다 대면 버튼이 어떻게 변하는 가..
		ok.setBorderPainted(false);
		ok.setFocusPainted(false);
		ok.setContentAreaFilled(false);
		
		cancle = new JButton(imgButton.cancleButton_edit);
		cancle.setRolloverIcon(imgButton.cancleButton_edit_1);
		cancle.setBorderPainted(false);
		cancle.setFocusPainted(false);
		cancle.setContentAreaFilled(false);
		
		nameL = new JLabel("<html><font size=5 style=나눔바른고딕>이름</font>", JLabel.CENTER);
		accountL = new JLabel("<html><font size=5 style=나눔바른고딕 >계좌번호</font>", JLabel.CENTER);
		pwL = new JLabel("<html><font size=5 style=나눔바른고딕>비밀번호</font>", JLabel.CENTER);
		balanceL = new JLabel("<html><font size=5 style=나눔바른고딕>입금금액</font>", JLabel.CENTER);
		
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
				
				//입력받은 값을 String으로 바꿈
				//바꿔야 DB에 저장하는 클래스에 메소드들에 값을 보낼 수 있음.
				name = nameIn.getText();
				account_num = accountIn.getText();
				pw = pwIn.getText();
				balanceIN = balanceIn.getText();
				
				name.toString();
				account_num.toString();
				pw.toString();
				balanceIN.toString();
				
				//입력받은 값들을 DbBean클래스에 있는 계좌생성하는 메소드로 보내서 계좌를 생성한다.
				//생성이 성공하면 1일 출력됨. 출력되면 성공했다는 창?을 띄우게 하는 메소드로 보낸다.
				if(bankDbBean.CreateUser(name, account_num, pw, balanceIN) == 1) {
					start.createChange("ok");
				}
				//실패하면 실패 창이 뜨게 하는 메소드로 보낸다.
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
