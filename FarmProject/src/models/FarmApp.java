package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class FarmApp {

	private ArrayList<Report> reports;
	private Inventory inventory;
	private ReproductionController reproductionController;
	private DiseaseController diseaseController;
	private ArrayList<Cow> cows;
	private ArrayList<Calf> calfs;
	private ArrayList<Breed> breeds;

	public FarmApp() {
		this.reproductionController = new ReproductionController();
		this.diseaseController = new DiseaseController();
	}

	public ArrayList<Report> getReports() {
		return reports;
	}

	public void setReports(ArrayList<Report> reports) {
		this.reports = new ArrayList<Report>();

		for (int i = 0; i < reports.size(); i++) {
			this.reports.add(reports.get(i));
		}

	}
	
	public void addReports(Report report) {
		this.reports.add(report);
	}

	public ArrayList<Cow> getCows() {
		return cows;
	}
	
	public ArrayList<Cow> getInseminatedCows() {
		return this.reproductionController.getInseminatedCows();
	}
	
	public ArrayList<Cow> getSickCows() {
		return this.diseaseController.getSickCow();
	}

	public void setCows(ArrayList<Cow> cows) {
		this.cows = cows;
	}
	
	public void addCows(Cow cow) {
		this.cows.add(cow);
	}

	public ArrayList<Breed> getBreeds() {
		return breeds;
	}

	public void setBreeds(ArrayList<Breed> breeds) {
		this.breeds = breeds;
	}

	public void addInsemination(Cow cow, String insDay) {
		this.reproductionController.addInsemination(cow,insDay);
	}

	public void addHeat(Cow cow, String heatDay) {
		this.reproductionController.addHeat(cow,heatDay);

	}

	public void addCalf(Calf calf) {
		this.calfs.add(calf);
	}
	
	public ArrayList<Calf> getCalfs() {
		return calfs;
	}

	public void setCalfs(ArrayList<Calf> calfs) {
		this.calfs = calfs;
	}

	public ReproductionController getRepController() {
		return this.reproductionController;
	}

	public DiseaseController getDisController() {
		return this.diseaseController;
	}

	public Report getReport(LocalDate date) {
		Report r = null;
		for (int i = 0; i < this.cows.size(); i++) {
			if (this.reports.get(i).getReportDate().equals(date.format(DateTimeFormatter.ISO_DATE))) {
				r = this.reports.get(i);
			}
		}
		return r;
	}

	public void setCowState(Cow cow, CowState cowState) {
		cow.setCowstate(cowState);
	}

	public void createReport(Report report) {
		
	}

	public void setInventory(int rentMilk, int salt, int preLactation) {
		this.inventory.setInventory(rentMilk,salt,preLactation);
	}

	public void deleteCows(Cow cow) {
		this.cows.remove(cow);
	}

	public void deleteCalf(Calf calfToDelete) {
		this.calfs.remove(calfToDelete);
	}

	public void addSick(Cow cowInseminated) {
		searchCow(cowInseminated.getId()).setDiseases(cowInseminated.getDiseases());
	}
	
	public Cow searchCow(String id) {
		for (int i = 0; i < this.cows.size(); i++) {
			if (this.cows.get(i).getId().equals(id)) {
				return this.cows.get(i);
			}
		}
		return null;
	}

	public void addMedicament(Cow cowWithSick) {
		searchCow(cowWithSick.getId()).setMedicineApplied(cowWithSick.getMedicineApplied());

	}
}
