package controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Calf;
import models.Cow;
import models.FarmApp;
import models.Manager;
import views.View;

public class Controller implements ActionListener {

	private Manager mg;
	public FarmApp farmApp;
	public View view;

	public Controller() {
		this.farmApp = new FarmApp();
		this.mg = new Manager();
		this.farmApp.setReports(this.mg.readReportJson(mg.readJson("resources/reports/reports.json")));
		this.farmApp.setCows(this.mg.readCowJson(mg.readJson("resources/cows/cows.json")));
		this.farmApp.setBreeds(this.mg.readBreed(mg.readJson("resources/breeds/breeds.json")));
		this.farmApp.setCalfs(this.mg.readCalf(mg.readJson("resources/calfs/calfs.json")));
		this.view = new View(this);
		this.view.setCows(this.farmApp.getCows());
		this.view.setBreeds(this.farmApp.getBreeds());
		this.view.setCalfs(this.farmApp.getCalfs());
		//this.view.setSickCows(this.farmApp.getSickCows());
	}

	public static void main(String[] args) {
		Controller c = new Controller();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		switch (command) {
		case "search":
			this.view.setInfoSearcher(this.view.getCowInfo());
			break;
		case "Agregar Vaca":
			Cow cow = new Cow(this.view.getNewCowId(), this.view.getBreed());
			this.mg.writeCow(cow);
			this.farmApp.addCows(cow);
			this.view.addCow(cow);
			break;
		case "Agregar Cria":
			Calf calf = this.view.getNewCalf();
			this.mg.writeCalf(calf);
			this.farmApp.addCalf(calf);
			this.view.addCalf(calf);
			break;
		case "Eliminar Vaca":
			Cow cowToDelete = this.view.getCowToDelete();
			this.mg.deleteCow(cowToDelete);
			this.farmApp.deleteCows(cowToDelete);
			this.view.deleteCow(cowToDelete);
			break;
		case "Eliminar Cria":
			Calf calfToDelete = this.view.getCalfToDelete();
			this.mg.deleteCalf(calfToDelete);
			this.farmApp.deleteCalf(calfToDelete);
			this.view.deleteCalf(calfToDelete);
			break;
		case "Principal":
			CardLayout home = (CardLayout) this.view.getBody().getLayout();
			home.show(this.view.getBody(), "Principal");
			break;
		case "Ctrl. Reproduccion":
			CardLayout reproduction = (CardLayout) this.view.getBody().getLayout();
			reproduction.show(this.view.getBody(), "Ctrl. Reproduccion");
			break;
		case "Ctrl. Enfermedades":
			CardLayout desease = (CardLayout) this.view.getBody().getLayout();
			desease.show(this.view.getBody(), "Ctrl. Enfermedades");
			break;
		case "Reportes":
			CardLayout reports = (CardLayout) this.view.getBody().getLayout();
			reports.show(this.view.getBody(), "Reportes");
			break;
		case "Agregar Inseminacion":
			this.farmApp.addInsemination(this.view.getCowInseminated(), this.view.getInseminationDate());
			this.mg.addInsemination(this.view.getCowInseminated(), this.view.getInseminationDate());
			this.view.addInsemination(this.view.getCowInseminated());
			break;
		case "Cambiar Estado":

			break;
		case "Agregar enfermedad":
			this.farmApp.addSick(this.view.getCowWithSick());
			this.mg.addSick(this.view.getCowWithSick());
			this.view.addSick(this.view.getCowWithSick());
			break;
		case "Agregar medicamento":
			this.farmApp.addMedicament(this.view.getCowWithMed());
			this.mg.addMedicament(this.view.getCowWithMed());
			this.view.addMedicament(this.view.getCowWithMed());
			break;
		default:
			break;
		}
	}

}
