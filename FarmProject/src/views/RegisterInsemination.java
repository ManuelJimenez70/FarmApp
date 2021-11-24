package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Cow;

public class RegisterInsemination extends JPanel {

	private MyLabel txt, lbCow, lbYear, lbMonth, lbDay;
	private JLabel icon;
	private JComboBox<Cow> cows;
	private JComboBox<Integer> cbYear, cbMonth, cbDay;
	private MyButton button;

	public RegisterInsemination(ActionListener actionListener) {
		this.setLayout(new GridBagLayout());
		setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(800, 220));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		this.txt = new MyLabel("<html>AGREGAR FECHA DE INSEMINACION<html>");
		this.icon = new JLabel(new ImageIcon("resources/images/insemination.jpg"));
		this.lbCow = new MyLabel(" Vaca : ");
		this.lbYear = new MyLabel(" Anio :");
		this.lbMonth = new MyLabel(" Mes :");
		this.lbDay = new MyLabel(" Dia :");
		this.cows = new JComboBox<Cow>();
		this.cbYear = new JComboBox<Integer>();
		this.cbMonth = new JComboBox<Integer>();
		this.cbDay = new JComboBox<Integer>();
		this.button = new MyButton(actionListener, "Agregar Inseminacion");
		initLists();
		addComponents();
	}

	public void setCows(ArrayList<Cow> cows) {
		this.cows.removeAllItems();
		for (int i = 0; i < cows.size(); i++) {
			this.cows.addItem(cows.get(i));
		}
	}

	public void addComponents() {
		GridBagConstraints g = new GridBagConstraints();
		g.gridx = 0;
		g.gridy = 0;
		g.anchor = GridBagConstraints.WEST;
		g.ipadx = 15;
		g.ipady = 20;
		g.gridwidth = 9;
		g.gridheight = 1;
		this.add(txt, g);
		g.gridwidth = 1;
		g.gridy = 1;
		g.ipady = 40;

		this.add(lbCow, g);
		g.gridwidth = 2;
		g.gridx = 1;
		g.ipady = 0;

		this.add(cows, g);
		g.gridx = 3;
		g.gridwidth = 1;
		this.add(lbYear, g);
		g.gridx = 4;
		this.add(cbYear, g);
		g.gridx = 5;
		this.add(lbMonth, g);
		g.gridx = 6;
		this.add(cbMonth, g);
		g.gridx = 7;
		this.add(lbDay, g);
		g.gridx = 8;
		this.add(cbDay, g);
		g.gridx = 9;
		this.add(this.icon, g);
		g.gridx = 4;
		g.gridy = 2;
		g.gridwidth = 2;
		this.add(button, g);
	}

	private void initLists() {
		this.cows = new JComboBox<Cow>();
		this.cbDay = new JComboBox<Integer>();
		for (int i = 1; i < 31; i++) {
			this.cbDay.addItem(i);
		}
		this.cbMonth = new JComboBox<Integer>();
		for (int i = 1; i < 13; i++) {
			this.cbMonth.addItem(i);
		}
		this.cbYear = new JComboBox<Integer>();
		for (int i = 2000; i < 2051; i++) {
			this.cbYear.addItem(i);
		}
	}
	
	public String getDate() {
		return this.cbYear.getSelectedItem().toString()+"-"+this.cbMonth.getSelectedItem().toString()+"-"+this.cbDay.getSelectedItem().toString();
	}

	public Cow getCowToInseminated() {
		return (Cow) this.cows.getSelectedItem();
	} 
}