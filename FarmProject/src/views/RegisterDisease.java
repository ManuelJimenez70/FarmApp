package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import models.Cow;

public class RegisterDisease extends JPanel {

    private AddDiseasePanel addDisease, addMedicine;

    public RegisterDisease(ActionListener actionListener) {
        this.setLayout(new GridLayout(1, 2));
        setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(800, 500));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        this.addDisease = new AddDiseasePanel(actionListener, "AGREGAR ENFERMEDAD", "Enfermedad ", "resources/images/disease.png","Agregar enfermedad");
        this.add(this.addDisease);
        this.addMedicine = new AddDiseasePanel(actionListener, "AGREGAR MEDICAMENTO", "Medicamento ", "resources/images/jeringa.jpg","Agregar medicamento");
        this.add(this.addMedicine);
    }
    
    public void setSickCows(ArrayList<Cow> cows) {
		this.addMedicine.getSickCows().removeAllItems();

		for (int i = 0; i < cows.size(); i++) {
			this.addMedicine.getSickCows().addItem(cows.get(i));
		}
	}
    
    public void setAllCows(ArrayList<Cow> cows) {
		this.addDisease.getSickCows().removeAllItems();
		for (int i = 0; i < cows.size(); i++) {
			this.addDisease.getSickCows().addItem(cows.get(i));
		}
	}
    
    public Cow getCowWithSick() {
    	Cow sick = this.addDisease.getSickCow();
    	sick.setDiseases(this.addDisease.getString());
    	ArrayList<String> sicks = sick.getDiseases();
    	Set<String> hashSet = new HashSet<String>(sicks);
		sicks.clear();
		sicks.addAll(hashSet);
		sick.setDiseases(sicks);
    	return sick;
    }
    
    public Cow getCowWithMed() {
    	Cow sick = this.addMedicine.getSickCow();
    	sick.setMedicineApplied(this.addMedicine.getString());
    	ArrayList<String> sicks = sick.getMedicineApplied();
    	Set<String> hashSet = new HashSet<String>(sicks);
		sicks.clear();
		sicks.addAll(hashSet);
		sick.setMedicineApplied(sicks);
    	return sick;
    }
}