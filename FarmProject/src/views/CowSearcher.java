package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Cow;

public class CowSearcher extends JPanel {

	private JComboBox<Cow> cows;
	private CowPanel cowPanel;

	public CowSearcher(ActionListener actionListener) {
		this.setLayout(new GridBagLayout());
		setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(1000, 280));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		GridBagConstraints g = new GridBagConstraints();
		this.cows = new JComboBox<Cow>();
		this.cows.setActionCommand("search");
		this.cows.addActionListener(actionListener);
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 1;
		this.add(new JLabel("Vaca: "), g);
		g.gridx = 1;
		this.add(this.cows, g);
		this.cowPanel = new CowPanel();
		g.gridx = 0;
		g.gridy = 1;
		g.gridwidth = 2;

		this.add(this.cowPanel, g);
	}

	
	public void setInfo(Cow cow) {
		this.cowPanel.setInfo(cow);
	}

	public Cow getCowInfo() {
		return (Cow) this.cows.getSelectedItem();
	}

	public void setCows(ArrayList<Cow> cows) {
		this.cows.removeAllItems();
		for (int i = 0; i < cows.size(); i++) {
			this.cows.addItem(cows.get(i));
		}
	}

}
