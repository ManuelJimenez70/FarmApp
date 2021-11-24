package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import models.Cow;

public class DiseasePanel extends JPanel {

	private Presenter presenterDisease;
	private RegisterDisease registerDisease;
	private MyDiseaseTable diseaseTable;
	private SickCowDeleter sickCowDeleter;

	public DiseasePanel(ActionListener actionListener) {
		this.setLayout(new FlowLayout());
		setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(1000, 1430));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		this.presenterDisease = new Presenter("resources/images/cowDisease.jpg",
				"\n\tCONTROL DE ENFERMEDADES    \n  ¡Registros y tratamientos de vacas enfermas que podrian\r\n"
						+ "  tener un impacto en la produccion de leche.");
		this.registerDisease = new RegisterDisease(actionListener);
		this.sickCowDeleter = new SickCowDeleter(actionListener);
		this.diseaseTable = new MyDiseaseTable();
		this.add(this.presenterDisease);
		this.add(this.registerDisease);
		this.add(this.sickCowDeleter);
		this.add(this.diseaseTable);
	}

	@Override
	public void paint(java.awt.Graphics g) {
		ImageIcon i = new ImageIcon("resources/images/body.png");
		g.drawImage(i.getImage(), 0, 0, this.getSize().width, this.getSize().height, null);
		this.setOpaque(false);
		super.paint(g);
	}

	public Cow getCowWithSick() {
		return this.registerDisease.getCowWithSick();
	}

	public Cow getCowWithMed() {
		return this.registerDisease.getCowWithMed();
	}

	public void setCows(ArrayList<Cow> cows) {
		this.registerDisease.setSickCows(setSickCows(cows));
		this.registerDisease.setAllCows(cows);
		this.diseaseTable.setCows(setSickCows(cows));
		this.sickCowDeleter.setSickCows(setSickCows(cows));
	}

	public ArrayList<Cow> setSickCows(ArrayList<Cow> cows) {
		ArrayList<Cow> sickCows = new ArrayList<Cow>();
		for (int i = 0; i < cows.size(); i++) {
			if (cows.get(i).getDiseases() != null && cows.get(i).getDiseases().size() != 0) {
				sickCows.add(cows.get(i));
			}
		}
		return sickCows;
	}

	public Cow getCowHealthy() {
		return this.sickCowDeleter.getCowHealthy();
	}
}