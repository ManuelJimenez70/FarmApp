package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Cow;

public class CalfAditor extends JPanel {
	
	private MyLabel description;
	private MyButton reproductor;
	public CalfAditor(ActionListener actionListener) {
		this.setLayout(new GridBagLayout());
		setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(500, 280));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		this.description = new MyLabel("<html>Para agregar una nueva cria dirigase al control de reproduccion.<html>");
		this.description.setMinimumSize(new Dimension(300,30));
		this.reproductor = new MyButton(actionListener, "Ctrl. Reproduccion");
		addComponents();
	}

	private void addComponents() {
		GridBagConstraints g = new GridBagConstraints();
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 1;
		g.gridheight = 1;
		JLabel lblAdd = new JLabel("AGREGAR CRIA: ");
		lblAdd.setBackground(Color.WHITE);
		lblAdd.setFont(new Font("Agency FB", Font.PLAIN, 25));
		lblAdd.setForeground(Color.RED);
		this.add(lblAdd);
		g.ipadx = 15;
		g.ipady = 80;
		g.gridy = 1;
		g.gridwidth = 3;
		this.add(this.description,g);
		g.ipady = 0;
		g.gridy = 2;
		this.add(this.reproductor,g);
	}
	
}
