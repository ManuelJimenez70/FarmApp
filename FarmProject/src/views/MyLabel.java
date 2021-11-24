package views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;

public class MyLabel extends JLabel{
	public MyLabel(String text) {
		this.setBackground(Color.WHITE);
		this.setFont(new Font("Agency FB", Font.PLAIN, 20));
		this.setForeground(Color.BLACK);
		this.setText(text);
	}
}
