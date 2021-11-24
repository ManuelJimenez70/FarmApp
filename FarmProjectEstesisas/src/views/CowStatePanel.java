package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import models.Cow;
import models.CowState;

public class CowStatePanel extends JPanel{
	
	private MyLabel txt,cow,state;
	private JComboBox<Cow> cows;
	private JComboBox<CowState> states;
	private MyButton button;

	public CowStatePanel(ActionListener actionListener) {
		this.setLayout(new GridBagLayout());
		setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(800, 180));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		initLists();
		initComponents(actionListener);
	}
	
	private void initComponents(ActionListener actionListener) {
		this.txt = new MyLabel("CAMBIAR ESTADO DE LA VACA");
		this.txt.setForeground(new Color(28, 82, 153));
		this.cow = new MyLabel("Vaca : ");
		this.state = new MyLabel("Estado : ");
		this.button = new MyButton(actionListener,"Cambiar Estado");
		GridBagConstraints g = new GridBagConstraints();
		g.gridx = 0;
		g.gridy = 0;
		g.ipady = 20;
		this.add(this.txt,g);
		g.gridy = 1;
		g.weightx = 1;
		g.gridheight = 1;
		this.add(cow, g);
		g.gridx = 1;
		g.fill= GridBagConstraints.CENTER;
		g.ipady = 0;
		this.add(cows,g);
		g.gridx = 2;
		this.add(state, g);
		g.gridx = 3;
		this.add(states,g);
		g.gridx = 1;
		g.gridy = 3;
		this.add(button,g);
	}
	
	private void initLists() {
		this.cows = new JComboBox<Cow>();
		this.cows.setBackground(Color.WHITE);
		this.states = new JComboBox<CowState>();
		this.states.setBackground(Color.WHITE);
		for (int i = 0; i < CowState.values().length; i++) {
			this.states.addItem(CowState.values()[i]);
		}
	}
	
	public CowState getCowState() {
		return (CowState)this.states.getSelectedItem();
	}
	
	public Cow getCow() {
		return (Cow) this.cows.getSelectedItem();
	}
	
	public void setCows(ArrayList<Cow> cows) {
		this.cows.removeAllItems();
		for (int i = 0; i < cows.size(); i++) {
			this.cows.addItem(cows.get(i));
		}
	}
}