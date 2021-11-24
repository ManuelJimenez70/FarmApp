package models;

import java.util.ArrayList;

public class Cow {

	private String id;
	private ArrayList<Calf> calfs;
	private CowState cowstate;
	private ArrayList<String> diseases;
	private ArrayList<String> medicineApplied;
	private String heatDate;
	private String inseminationDate;
	private Breed breed;

	public Cow(String id, Breed breed) {
		super();
		this.id = id;
		this.calfs = new ArrayList<Calf>();
		this.cowstate = CowState.SIN;
		this.diseases = new ArrayList<String>();
		this.medicineApplied = new ArrayList<String>();
		this.heatDate = "Sin Especificar";
		this.inseminationDate = "Sin Especificar";
		this.breed = breed;
	}

	public Cow() {
		this.calfs = new ArrayList<Calf>();
		this.cowstate = CowState.SIN;
		this.diseases = new ArrayList<String>();
		this.medicineApplied = new ArrayList<String>();
		this.heatDate = "Sin Especificar";
		this.inseminationDate = "Sin Especificar";
	}

	public void addDisease(String disease) {
		this.diseases.add(disease);
	}

	public void addMedicine(String medicine) {
		this.medicineApplied.add(medicine);
	}

	public void addCalf(Calf calf) {
		this.calfs.add(calf);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Calf> getCalfs() {
		return calfs;
	}

	public void setCalfs(ArrayList<Calf> calfs) {
		this.calfs = calfs;
	}

	public CowState getCowstate() {
		return cowstate;
	}

	public void setCowstate(CowState cowstate) {
		this.cowstate = cowstate;
	}

	public ArrayList<String> getDiseases() {
		return diseases;
	}

	public void setDiseases(ArrayList<String> diseases) {
		this.diseases = diseases;
	}

	public ArrayList<String> getMedicineApplied() {
		return medicineApplied;
	}

	public void setMedicineApplied(ArrayList<String> medicineApplied) {
		this.medicineApplied = medicineApplied;
	}

	public String getHeatDate() {
		return heatDate;
	}

	public void setHeatDate(String heatDate) {
		this.heatDate = heatDate;
	}

	public String getInseminationDate() {
		return inseminationDate;
	}

	public void setInseminationDate(String insDay) {
		this.inseminationDate = insDay;
	}

	public void setDiseases(String disease) {
		this.diseases.add(disease);
	}

	public void setMedicineApplied(String medicineApplied) {
		this.medicineApplied.add(medicineApplied);
	}

	public Breed getBreed() {
		return breed;
	}

	public void setBreed(Breed breed) {
		this.breed = breed;
	}

	@Override
	public String toString() {
		return this.id;
	}

}
