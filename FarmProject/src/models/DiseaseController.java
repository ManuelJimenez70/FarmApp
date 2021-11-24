package models;

import java.util.ArrayList;

public class DiseaseController {
	private ArrayList<Cow> sickCow;

	public DiseaseController() {
	}

	public ArrayList<Cow> getSickCow() {
		return sickCow;
	}

	public void setSickCows(ArrayList<Cow> cows) {
		for (int i = 0; i < cows.size(); i++) {
			if (cows.get(i).getDiseases() != null) {
				this.sickCow.add(cows.get(i));
			}
		}
	}

	public void deleteCow(Cow cow) {
		this.sickCow.remove(cow);
	}

	public Cow searchCow(String id) {
		Cow cow = null;
		for (int i = 0; i < this.sickCow.size(); i++) {
			if (this.sickCow.get(i).getId().equals(id)) {
				cow = this.sickCow.get(i);
			}
		}
		return cow;
	}

	public void addSickCow(Cow cow, String disease) {
		cow.setDiseases(disease);
	}

	public void addMedicine(Cow cow, String medicine) {
		cow.setMedicineApplied(medicine);
	}

}
