package bank_gui;

import java.awt.*;

import javax.swing.*;

public class OkCancleButton {
	ImageIcon okButton = new ImageIcon(CreateAccount.class.getResource("/image/ok.png"));
	ImageIcon okButton_edit = new ImageIcon(okButton.getImage().getScaledInstance(164, 63, Image.SCALE_DEFAULT));
	ImageIcon cancleButton= new ImageIcon(CreateAccount.class.getResource("/image/cancle.png"));
	ImageIcon cancleButton_edit = new ImageIcon(cancleButton.getImage().getScaledInstance(164, 63, Image.SCALE_DEFAULT));
	
	ImageIcon okButton_1= new ImageIcon(CreateAccount.class.getResource("/image/ok1.png"));
	ImageIcon okButton_edit_1 = new ImageIcon(okButton_1.getImage().getScaledInstance(164, 63, Image.SCALE_DEFAULT));
	ImageIcon cancleButton_1 = new ImageIcon(CreateAccount.class.getResource("/image/cancle1.png"));
	ImageIcon cancleButton_edit_1 = new ImageIcon(cancleButton_1.getImage().getScaledInstance(164, 63, Image.SCALE_DEFAULT));
}
