package controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import models.Calf;
import models.Cow;
import models.CowState;
import models.FarmApp;
import models.Manager;
import models.Report;
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
		this.view.setReports(this.farmApp.getReports());
		//this.view.setSickCows(this.farmApp.getSickCows());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		switch (command) {
		case "search":
			this.view.setInfoSearcher(this.view.getCowInfo());
			break;
		case "Agregar Vaca":
			if (JOptionPane.showConfirmDialog(
                    null, "¿Desea agregar una nueva vaca?",
                    "Agregar vaca",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				Cow cow = new Cow(this.view.getNewCowId(), this.view.getBreed());
				this.mg.writeCow(cow);
				this.farmApp.addCows(cow);
				this.view.addCow(cow);
			}
			
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
			this.farmApp.addInsemination(this.view.getCowtoInsemination(), ((View) this.view).getDateIntamination());
			this.mg.addInsemination(this.view.getCowtoInsemination(), this.view.getDateIntamination());
			this.view.addInsemination(this.view.getCowtoInsemination());
			break;
		case "Agregar Ultimo Celo":
			Cow cowHeat = this.view.getCowtoHeat();
			this.farmApp.addHeat(cowHeat, this.view.getDateHeat());
			this.mg.addDateHeat(cowHeat, this.view.getDateHeat());
			this.view.addDateHeat(cowHeat, this.view.getDateHeat());
			break;	
		case "Cambiar Estado":
			Cow c = this.view.getCow();
			CowState state = this.view.getCowState();
			if (this.view.getCowState().equals(CowState.INSEMINATED)) {
				this.farmApp.addInsemination(c, "2000-1-1");
				this.mg.addInsemination(c,"2000-1-1");
				this.view.addInsemination(c);
			}else {
				this.farmApp.setCowState(c,state);
				this.mg.addState(c,state);
				this.view.changeState(c,state);	
			}	
			break;
		case "Agregar enfermedad":
			Cow sick = this.view.getCowWithSick();
            this.farmApp.addSick(sick);
            this.mg.addSick(sick);
            this.view.addSick(sick);
            break;
        case "Agregar medicamento":
        	Cow cowMed = this.view.getCowWithMed();
            this.farmApp.addMedicament(cowMed);
            this.mg.addMedicament(cowMed);
            this.view.addMedicament(cowMed);
            break;
        case "Eliminar Vaca Enferma":
        	Cow cowHealthy = this.view.getCowHealthy();
            this.farmApp.deleteSickCow(cowHealthy);
            this.mg.deleteSickCow(cowHealthy);
            this.view.deleteSickCow(cowHealthy);
            break;
        case "Generar Reporte":
        	Report gr = this.view.getReport();
        	this.mg.writeReport(gr);
        	this.farmApp.addReport(gr);
        	this.view.setReports(farmApp.getReports());
        	this.view.delInventory(gr.getInventoryConsumed());
            break;
        case "Consultar Reporte":
        	this.view.setInfoReport();
            break;		
        case "Agregar inventario":
    	this.view.addInventory(this.view.getAddInventory());
        break;	    
		default:
			break;
		}
	}

}
