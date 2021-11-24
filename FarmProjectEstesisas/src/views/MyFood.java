package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFood extends JPanel {

	private JLabel icon;
	private MyLabel name, quantity;
	private JTextField jTxt;

	public MyFood(String icon, String name, String thing) {
		this.setLayout(new GridBagLayout());
		setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(240, 130));
		iniComponents(icon, name, thing);
	}

	private void iniComponents(String icon, String name, String thing) {
		this.icon = new JLabel();
		this.icon.setIcon(new ImageIcon(icon));
		this.name = new MyLabel(name);
		this.quantity = new MyLabel(thing);
		this.jTxt = new JTextField(10);
		this.jTxt.setMinimumSize(new Dimension(50, 20));
		addComponents();
	}

	public void addComponents() {
		GridBagConstraints g = new GridBagConstraints();
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 1;
		g.gridheight = 1;
		g.ipadx = 20;
		g.ipady = 10;
		this.add(this.icon, g);
		g.gridx = 1;
		this.add(this.name, g);
		g.gridx = 0;
		g.gridy = 1;
		this.add(this.quantity, g);
		g.gridx = 1;
		g.gridy = 1;
		g.ipady = 0;
		this.add(this.jTxt, g);
	}

	public int getQuantity() {
		if (isNumeric(this.jTxt.getText().trim())) {
			return Integer.parseInt(this.jTxt.getText().trim());
		} else {
			return 0;
		}
	}

	private static boolean isNumeric(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

}