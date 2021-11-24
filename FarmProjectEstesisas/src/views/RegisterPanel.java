package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class RegisterPanel extends JPanel {

	private JLabel icon;
	private JTextArea description;
	private MyButton button;

	public RegisterPanel(ActionListener actionListener, String icon, String description, String button) {
		this.setLayout(new GridBagLayout());
		setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(300, 500));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		initComponents(actionListener, icon, description, button);
	}

	private void initComponents(ActionListener actionListener, String icon, String description, String button) {
		
		this.icon = new JLabel(new ImageIcon(icon));
		this.description = new JTextArea(description);
		this.description.setFont(new Font("Agency FB", Font.PLAIN, 20));
		this.description.setEditable(false);
		this.button = new MyButton(actionListener, button);
		GridBagConstraints g = new GridBagConstraints();
		g.gridx = 0;
		g.gridy = 0;
		g.ipady = 50;
		g.fill = g.VERTICAL;
		this.add(this.icon,g);
		g.ipady = 20;
		g.gridy = 1;
		this.add(this.description,g);
		g.gridy = 2;
		g.ipady = 0;
		g.fill = g.NONE;
		this.add(this.button,g);
	}
}
