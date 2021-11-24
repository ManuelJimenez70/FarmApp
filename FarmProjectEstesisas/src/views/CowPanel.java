package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Cow;

public class CowPanel extends JPanel {

	private JLabel icon, id, state, heat, breed, description;
	private MyLabel lblId, lblState, lblHeat, lblBreed, lblDescription;

	public CowPanel() {
		this.setLayout(new GridBagLayout());
		setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(600, 280));
		initComponents();
	}

	private void initComponents() {
		this.icon = new JLabel(new ImageIcon("resources/images/breeds/breeds.png"));
		this.lblId = new MyLabel("Id o Nombre: ");
		this.lblState = new MyLabel("Estado: ");
		this.lblHeat = new MyLabel("Fecha del Ultimo Calor: ");
		this.lblBreed = new MyLabel("Raza: ");
		this.lblDescription = new MyLabel("Descripcion: ");
		this.id = new JLabel(" ");
		this.state = new JLabel(" ");
		this.heat = new JLabel(" ");
		this.breed = new JLabel(" ");
		this.description = new JLabel(" ");
		this.description.setPreferredSize(new Dimension(300, 30));
		this.description.setMinimumSize(new Dimension(300, 40));
		addComponents();
	}

	private void addComponents() {
		GridBagConstraints g = new GridBagConstraints();
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 1;
		g.gridheight = 5;
		g.anchor = g.WEST;
		this.add(this.icon, g);
		g.ipadx = 5;
		g.ipady = 10;
		g.gridx = 1;
		g.gridy = 0;
		g.gridwidth = 1;
		g.gridheight = 1;
		this.add(this.lblId, g);
		g.gridx = 2;
		this.add(this.id, g);
		g.gridx = 1;
		g.gridy = 1;
		this.add(this.lblState, g);
		g.gridx = 2;
		this.add(this.state, g);
		g.gridx = 1;
		g.gridy = 2;
		this.add(this.lblHeat, g);
		g.gridx = 2;
		this.add(this.heat, g);
		g.gridx = 1;
		g.gridy = 3;
		this.add(this.lblBreed, g);
		g.gridx = 2;
		this.add(this.breed, g);
		g.gridx = 1;
		g.gridy = 4;
		this.add(this.lblDescription, g);
		g.gridx = 2;
		g.fill = g.HORIZONTAL;
		this.add(this.description, g);
	}

	public void setIcon(String icon) {
		this.icon.setIcon(new ImageIcon(icon));
	}

	public void setId(String id) {
		this.id.setText(id);
	}

	public void setState(String state) {
		this.state.setText(state);
	}

	public void setHeat(String heat) {
		this.heat.setText(heat);
	}

	public void setBreed(String breed) {
		this.breed.setText(breed);
	}

	public void setDescription(String description) {
		this.description.setText("<html>" + description + "<html>");
	}

	public void setInfo(Cow cow) {
		if (cow != null) {
			setId(cow.getId());
			setState(cow.getCowstate().name());
			setHeat(cow.getHeatDate());
			setBreed(cow.getBreed().getName());
			setDescription(cow.getBreed().getDescription());
			setIcon(cow.getBreed().getIcon());
		}
	}
}
