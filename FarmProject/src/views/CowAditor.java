package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Breed;

public class CowAditor extends JPanel {

	private MyLabel id, cow, breed;
	private JTextField txtCow;
	private JComboBox<Breed> breeds;
	private MyButton addBtn;

	public CowAditor(ActionListener actionListener) {
		this.setLayout(new GridBagLayout());
		setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(500, 280));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		this.cow = new MyLabel("VACA: ");
		this.id = new MyLabel("Nombre o Id: ");
		this.txtCow = new JTextField(10);
		this.breed = new MyLabel("Raza");
		this.breeds = new JComboBox<Breed>();
		this.breeds.addActionListener(actionListener);
		this.addBtn = new MyButton(actionListener, "Agregar Vaca");
		addComponents();
	}
	
	public void setBreeds(ArrayList<Breed> breeds) {
		for (int i = 0; i < breeds.size(); i++) {
			this.breeds.addItem(breeds.get(i));
		}
	}
	
	public Breed getBreed() {
		return (Breed) this.breeds.getSelectedItem();
	}
	
	public String getNewCowId() {
		return this.txtCow.getText();
	}

	private void addComponents() {
		GridBagConstraints g = new GridBagConstraints();
		g.gridx = 0;
		g.gridwidth = 1;
		g.gridheight = 1;
		JLabel lblAdd = new JLabel("AGREGAR VACA: ");
		lblAdd.setBackground(Color.WHITE);
		lblAdd.setFont(new Font("Agency FB", Font.PLAIN, 25));
		lblAdd.setForeground(Color.RED);
		g.ipadx = 140;
		g.ipady = 50;
		g.anchor = g.NORTHWEST;
		this.add(lblAdd);
		g.anchor = g.WEST;
		g.ipadx = 30;
		g.ipady = 15;
		g.gridy = 1;
		this.add(this.id, g);
		g.anchor = g.CENTER;
		g.ipady = 5;
		g.gridx = 1;
		this.add(this.txtCow, g);
		g.anchor = g.WEST;
		g.gridx = 0;
		g.gridy = 2;
		g.ipady = 50;
		this.add(this.breed, g);
		g.ipady = 0;
		g.gridx = 1;
		this.add(this.breeds, g);
		g.anchor = g.CENTER;
		g.gridx = 0;
		g.gridy = 3;
		g.gridwidth = 2;
		this.add(this.addBtn, g);
	}
}
