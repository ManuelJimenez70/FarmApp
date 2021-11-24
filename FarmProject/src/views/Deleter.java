package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import models.Calf;
import models.Cow;

public class Deleter extends JPanel {
	
	private CowDeleter cowDeleter;
	private CalfDelater calfDeleter;

	public Deleter(ActionListener actionListener) {
		this.setLayout(new GridLayout(1, 2));
		setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(1000, 280));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		this.cowDeleter = new CowDeleter(actionListener);
		this.calfDeleter = new CalfDelater(actionListener);
		this.add(this.cowDeleter);
		this.add(this.calfDeleter);

	}

	public void setCows(ArrayList<Cow> cows) {
		this.cowDeleter.setCows(cows);
	}

	public Cow getCowToDelete() {
		return this.cowDeleter.getCowToDelete();
	}

	public void setCalfs(ArrayList<Calf> calfs) {
		this.calfDeleter.setCalfs(calfs);
	}

	public void addCalf(Calf calf) {
		this.calfDeleter.addCalf(calf);
	}

	public Calf getCalfToDelete() {
		return this.calfDeleter.getCalfToDelete();
	}

	public void deleteCalf(Calf calf) {
		this.calfDeleter.deleteCalf(calf);
	}


}
