package bank_gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//Main 클래스는 Start 클래스의 frame에서 메인 panel이다.
//버튼을 누르면 Start 클래스에 있는 panel전환 메소드에서 이벤트가 발생되어 panel이 전환된다.
public class Main extends JPanel{
	private Start start;
	
	public Main(Start start) {
		this.start = start;
		
		GridLayout g1 = new GridLayout(2, 0);
		
		//이 클래스는 Main클래스에서 쓸 이미지 버튼들을 모아 놓은 클래스이다.
		//코드 줄 수를 줄이고 싶어서 만들었다.
		MainButtons mb = new MainButtons();
		
		ImageIcon main = new ImageIcon(Main.class.getResource("/image/mainImage.png"));
		ImageIcon main_edit = new ImageIcon(main.getImage().getScaledInstance(503, 192, Image.SCALE_DEFAULT));
		
		JLabel mainImage = new JLabel(main_edit);
		
		setLayout(g1);
		
		add(mainImage);
		add(mb.buttonsPanel);
		
		mb.create.addActionListener(new ActionListener() { //create 버튼을 누르면 발생되는 이벤트
			@Override
			public void actionPerformed(ActionEvent e) {
				start.mainChange("create"); //start 클래스에 있는 mainChange에서 create라는 값을 받으면 계좌생성 패널로 전환이 되는 것임.
			}
		});
		
		mb.record.addActionListener(new ActionListener() { //record 버튼을 누르면 발생되는 이벤트
			@Override
			public void actionPerformed(ActionEvent e) {
				start.mainChange("record");
			}
		});
		
		mb.send.addActionListener(new ActionListener() { //send 버튼을 누르면 발생되는 이벤트
			@Override
			public void actionPerformed(ActionEvent e) {
				start.mainChange("send");
			}
		});
		
		mb.deposit.addActionListener(new ActionListener() { //deposit 버튼을 누르면 발생되는 이벤트
			@Override
			public void actionPerformed(ActionEvent e) {
				start.mainChange("deposit");
			}
		});
		
		mb.withdraw.addActionListener(new ActionListener() { //withdraw 버튼을 누르면 발생되는 이벤트
			@Override
			public void actionPerformed(ActionEvent e) {
				start.mainChange("withdraw");
			}
		});
	}
}
