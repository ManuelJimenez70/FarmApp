package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Cow;

public class CowDeleter extends JPanel {

	private JComboBox<Cow> cows;
	private MyLabel lblCow;
	private MyButton deleteCow;

	public CowDeleter(ActionListener actionListener) {
		this.setLayout(new GridBagLayout());
		setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(500, 280));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		this.cows = new JComboBox<Cow>();
		this.lblCow = new MyLabel("Vaca: ");
		this.cows.setMinimumSize(new Dimension(300, 20));
		this.cows.setBackground(Color.WHITE);
		this.deleteCow = new MyButton(actionListener, "Eliminar Vaca");
		addComponents();
	}

	private void addComponents() {
		GridBagConstraints g = new GridBagConstraints();
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 2;
		g.gridheight = 1;
		JLabel lblAdd = new JLabel("ELIMINAR VACA: ");
		lblAdd.setBackground(Color.WHITE);
		lblAdd.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lblAdd.setForeground(Color.RED);
		g.ipadx = 80;
		g.ipady = 30;
		g.anchor = g.WEST;
		this.add(lblAdd, g);
		g.ipady = 30;
		g.anchor = g.CENTER;
		g.gridy = 1;
		g.gridwidth = 1;
		this.add(this.lblCow, g);
		g.gridx = 1;
		g.ipady = 10;
		g.gridwidth = 1;
		g.ipady = 0;
		this.add(this.cows, g);
		g.gridx = 0;
		g.gridwidth = 2;
		g.gridy = 2;
		this.add(this.deleteCow, g);
	}

	public void setCows(ArrayList<Cow> cows) {
		this.cows.removeAllItems();
		for (int i = 0; i < cows.size(); i++) {
			this.cows.addItem(cows.get(i));
		}
	}

	public Cow getCowToDelete() {
		return (Cow) this.cows.getSelectedItem();
	}

}
