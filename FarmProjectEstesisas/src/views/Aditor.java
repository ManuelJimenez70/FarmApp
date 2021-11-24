package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import models.Breed;

public class Aditor extends JPanel{
	
	private CowAditor cowAditor;
	private CalfAditor calfAditor;
	public Aditor(ActionListener actionListener) {
		this.setLayout(new GridLayout(1, 2));
		setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(1000, 280));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		this.cowAditor = new CowAditor(actionListener);
		this.calfAditor = new CalfAditor(actionListener);
		this.add( this.cowAditor);
		this.add(this.calfAditor);
	}
	
	public void setBreeds(ArrayList<Breed> breeds) {
		this.cowAditor.setBreeds(breeds);
	}
	
	public Breed getBreed() {
		return this.cowAditor.getBreed();
	}
	
	public String getNewCowId() {
		return this.cowAditor.getNewCowId();
	}

}
