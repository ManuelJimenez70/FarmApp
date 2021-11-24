package views;


import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FoodLbl extends JPanel{
	
	private JLabel icon;
	private JLabel quantity;
	
	public FoodLbl(String text, String icon, String tip) {
		this.setLayout(new FlowLayout());
		this.setBackground(Color.WHITE);
		this.icon = new JLabel();
		this.icon.setText(text);
		this.icon.setIcon(new ImageIcon(icon));
		this.icon.setToolTipText(tip);
		this.quantity = new JLabel("0");
		this.add(this.icon);
		this.add(this.quantity);
	}
	
	public void setQuantity(int quantity) {
		this.quantity.setText(Integer.toString(quantity));
	}
}
