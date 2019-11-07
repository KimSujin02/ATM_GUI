package bank_gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//Main Ŭ������ Start Ŭ������ frame���� ���� panel�̴�.
//��ư�� ������ Start Ŭ������ �ִ� panel��ȯ �޼ҵ忡�� �̺�Ʈ�� �߻��Ǿ� panel�� ��ȯ�ȴ�.
public class Main extends JPanel{
	private Start start;
	
	public Main(Start start) {
		this.start = start;
		
		GridLayout g1 = new GridLayout(2, 0);
		
		//�� Ŭ������ MainŬ�������� �� �̹��� ��ư���� ��� ���� Ŭ�����̴�.
		//�ڵ� �� ���� ���̰� �; �������.
		MainButtons mb = new MainButtons();
		
		ImageIcon main = new ImageIcon(Main.class.getResource("/image/mainImage.png"));
		ImageIcon main_edit = new ImageIcon(main.getImage().getScaledInstance(503, 192, Image.SCALE_DEFAULT));
		
		JLabel mainImage = new JLabel(main_edit);
		
		setLayout(g1);
		
		add(mainImage);
		add(mb.buttonsPanel);
		
		mb.create.addActionListener(new ActionListener() { //create ��ư�� ������ �߻��Ǵ� �̺�Ʈ
			@Override
			public void actionPerformed(ActionEvent e) {
				start.mainChange("create"); //start Ŭ������ �ִ� mainChange���� create��� ���� ������ ���»��� �гη� ��ȯ�� �Ǵ� ����.
			}
		});
		
		mb.record.addActionListener(new ActionListener() { //record ��ư�� ������ �߻��Ǵ� �̺�Ʈ
			@Override
			public void actionPerformed(ActionEvent e) {
				start.mainChange("record");
			}
		});
		
		mb.send.addActionListener(new ActionListener() { //send ��ư�� ������ �߻��Ǵ� �̺�Ʈ
			@Override
			public void actionPerformed(ActionEvent e) {
				start.mainChange("send");
			}
		});
		
		mb.deposit.addActionListener(new ActionListener() { //deposit ��ư�� ������ �߻��Ǵ� �̺�Ʈ
			@Override
			public void actionPerformed(ActionEvent e) {
				start.mainChange("deposit");
			}
		});
		
		mb.withdraw.addActionListener(new ActionListener() { //withdraw ��ư�� ������ �߻��Ǵ� �̺�Ʈ
			@Override
			public void actionPerformed(ActionEvent e) {
				start.mainChange("withdraw");
			}
		});
	}
}
