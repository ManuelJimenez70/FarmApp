package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class MyButton extends JButton implements MouseListener {

	public MyButton(ActionListener actionListener, String text) {
		this.setBackground(Color.GRAY);
		this.setFont(new Font("Agency FB", Font.PLAIN, 19));
		this.addMouseListener(this);
		this.setText(text);
		this.setActionCommand(text);
		this.setForeground(Color.WHITE);
		this.setBorderPainted(false);
		this.addActionListener(actionListener);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource()==this) {

			this.setBackground(Color.WHITE);
			this.setFont(new Font("Agency FB", Font.PLAIN, 19));
			this.setForeground(Color.BLACK);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource().equals(this)) {
			this.setBackground(Color.GRAY);
			this.setFont(new Font("Agency FB", Font.PLAIN, 19));
			this.setForeground(Color.WHITE);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
}
