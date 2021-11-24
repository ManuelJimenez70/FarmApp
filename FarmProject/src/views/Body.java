package views;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import models.Breed;
import models.Calf;
import models.Cow;

public class Body extends JPanel {

	private Home home;
	private JScrollPane scrollPane;
	private ArrayList<Cow> cows;
	private ReproductorPanel reproductorPanel;
	private DiseasePanel diseasePanel;
	private ReportsPanel reportPanel;

	public Body(ActionListener actionListener) {
		this.setLayout(new CardLayout());
		setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(1300, 2000));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		this.home = new Home(actionListener);
		this.scrollPane = new JScrollPane();
		this.scrollPane.setViewportView(this.home);
		this.add(this.scrollPane, "Principal");

		this.reproductorPanel = new ReproductorPanel(actionListener);
		this.scrollPane = new JScrollPane();
		this.scrollPane.setViewportView(this.reproductorPanel);
		this.add(scrollPane, "Ctrl. Reproduccion");

		this.diseasePanel = new DiseasePanel(actionListener);
		this.scrollPane = new JScrollPane();
		this.scrollPane.setViewportView(this.diseasePanel);
		this.add(this.scrollPane, "Ctrl. Enfermedades");

		this.reportPanel = new ReportsPanel(actionListener);
		this.scrollPane = new JScrollPane();
		this.scrollPane.setViewportView(this.reportPanel);
		this.add(scrollPane, "Reportes");
	}

	public void setCows(ArrayList<Cow> cows) {
		Set<Cow> hashSet = new HashSet<Cow>(cows);
		cows.clear();
		cows.addAll(hashSet);
		this.cows = sort(cows);
		this.home.setCows(this.cows);
		this.reproductorPanel.setCows(this.cows);
		this.diseasePanel.setCows(this.cows);
	}

	public void setInfoSearcher(Cow cow) {
		this.home.setInfo(cow);
	}

	public Cow getCowInfo() {
		return this.home.getCowInfo();
	}

	public void setBreeds(ArrayList<Breed> breeds) {
		this.home.setBreeds(breeds);
	}

	public Breed getBreed() {
		return this.home.getBreed();
	}

	public ArrayList<Cow> getCows() {
		sort();
		return this.cows;
	}

	public ArrayList<Cow> sort(ArrayList<Cow> cows) {
		cows.sort(new Comparator<Cow>() {

			@Override
			public int compare(Cow o1, Cow o2) {
				return o1.getId().compareTo(o2.getId());
			}
		});
		return cows;
	}

	public void sort() {
		this.cows.sort(new Comparator<Cow>() {

			@Override
			public int compare(Cow o1, Cow o2) {
				return o1.getId().compareTo(o2.getId());
			}
		});
	}

	public String getNewCowId() {
		return this.home.getNewCowId();
	}

	public Cow getCowToDelete() {
		return this.home.getCowToDelete();
	}

	public void addCow(Cow cow) {
		this.cows.add(cow);
		this.setCows(this.cows);
	}

	public void deleteCow(Cow cow) {
		this.cows.remove(cow);
		this.setCows(this.cows);
	}

	public void setCalfs(ArrayList<Calf> calfs) {
		this.home.setCalfs(calfs);
	}

	public void addCalf(Calf calf) {
		this.home.addCalf(calf);
	}

	public Calf getCalfToDelete() {
		return this.home.getCalfToDelete();
	}

	public void deleteCalf(Calf calf) {
		this.home.deleteCalf(calf);
	}

	public Calf getNewCalf() {
		return this.reproductorPanel.getNewCalf();
	}

	public String getInseminationDate() {
		return this.reproductorPanel.getInseminationDate();
	}

	public Cow getCowInseminated() {
		return this.reproductorPanel.getCowInseminated();
	}

	public void addInsemination(Cow cowInseminated) {
		this.cows.add(cowInseminated);
		setCows(this.cows);
	}
	
	public Cow getCowWithSick() {
		return this.diseasePanel.getCowWithSick();
	}

	public Cow getCowWithMed() {
		return this.diseasePanel.getCowWithMed();
	}

	public void addSick(Cow cowWithSick) {
		this.cows.add(cowWithSick);
		setCows(this.cows);		
	}

	public void addMedicament(Cow cowWithMed) {
		this.cows.add(cowWithMed);
		setCows(this.cows);			
	}
}
