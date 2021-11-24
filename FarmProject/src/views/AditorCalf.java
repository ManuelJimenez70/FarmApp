package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Calf;
import models.Cow;
import models.Gender;

public class AditorCalf extends JPanel {

	private MyLabel lblAddCalf, lblCow, lblBull, lblCalf, lblYear, lblMonth, lblDay, lblGender;
	private JTextField txtBull, txtid;
	private JComboBox<Integer> year, month, day;
	private JComboBox<Cow> cows;
	private JComboBox<Gender> genders;
	private MyButton btnAddCalf;

	public AditorCalf(ActionListener actionListener) {
		this.setLayout(new GridBagLayout());
		setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(1000, 230));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		this.lblAddCalf = new MyLabel("AGREGAR CRIA: ");
		this.lblBull = new MyLabel("Toro o Padre: ");
		this.lblCalf = new MyLabel("Nombre o id: ");
		this.lblCow = new MyLabel("Vaca o Madre: ");
		this.lblDay = new MyLabel("  Dia: ");
		this.lblGender = new MyLabel("  Genero: ");
		this.lblMonth = new MyLabel("  Mes: ");
		this.lblYear = new MyLabel("  Anio:");
		this.txtBull = new JTextField(10);
		this.txtid = new JTextField(10);
		this.btnAddCalf = new MyButton(actionListener, "Agregar Cria");
		initLists();
		addComponents();
	}

	private void addComponents() {
		GridBagConstraints g = new GridBagConstraints();
		g.anchor = g.WEST;
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 2;
		g.gridheight = 1;
		g.ipadx = 15;
		g.ipady = 30;
		this.add(this.lblAddCalf, g);
		g.gridy = 1;
		this.add(this.lblCow, g);
		g.gridx = 2;
		g.ipady = 0;
		this.add(this.cows, g);
		g.gridx = 4;
		this.add(this.lblBull, g);
		g.gridx = 6;
		this.add(this.txtBull, g);
		g.gridx = 0;
		g.gridy = 2;
		g.ipady = 30;
		this.add(this.lblCalf, g);
		g.ipady = 0;
		g.gridx = 2;
		g.gridwidth = 1;
		this.add(this.txtid, g);
		g.gridx = 4;
		this.add(this.lblYear, g);
		g.gridx = 5;
		g.anchor = g.EAST;
		this.add(this.year, g);
		g.gridx = 6;
		this.add(this.lblMonth, g);
		g.gridx = 7;
		this.add(this.month, g);
		g.gridx = 8;
		this.add(this.lblDay, g);
		g.gridx = 9;
		this.add(this.day, g);
		g.gridx = 10;
		this.add(this.lblGender, g);
		g.gridx = 11;
		this.add(this.genders, g);
		g.gridx = 4;
		g.gridy = 3;
		g.gridwidth = 3;
		this.add(this.btnAddCalf, g);
	}

	private void initLists() {
		this.cows = new JComboBox<Cow>();
		this.day = new JComboBox<Integer>();
		for (int i = 1; i < 31; i++) {
			this.day.addItem(i);
		}
		this.month = new JComboBox<Integer>();
		for (int i = 1; i < 13; i++) {
			this.month.addItem(i);
		}
		this.year = new JComboBox<Integer>();
		for (int i = 2000; i < 2051; i++) {
			this.year.addItem(i);
		}
		this.genders = new JComboBox<Gender>();
		for (int i = 0; i < Gender.values().length; i++) {
			this.genders.addItem(Gender.values()[i]);
		}
	}

	public void setCows(ArrayList<Cow> cows2) {
		this.cows.removeAllItems();
		for (int i = 0; i < cows2.size(); i++) {
			this.cows.addItem(cows2.get(i));
		}
	}

	public Calf getNewCalf() {
		try {
			Calf c = new Calf(this.txtid.getText(),
					this.year.getSelectedItem().toString() + "-" + this.month.getSelectedItem().toString() + "-" + this.day.getSelectedItem().toString(),
					this.txtBull.getText(), (Gender) this.genders.getSelectedItem());
			return c;
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return null;
	}

}
