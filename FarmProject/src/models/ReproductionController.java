package models;

import java.util.ArrayList;

public class ReproductionController {

	private ArrayList<Cow> inseminatedCows;

	public ReproductionController() {
		this.inseminatedCows  = new ArrayList<Cow>();
	}

	public void setCowsInseminated(ArrayList<Cow> cows) {
		if (cows!=null) {
			for (int i = 0; i < cows.size(); i++) {
				if (cows.get(i)!= null && cows.get(i).getCowstate().equals(CowState.INSEMINATED)) {
					this.inseminatedCows.add(cows.get(i));
				} 
			}
		}
	}

	public void delInseminatedCow(Cow cow) {
		this.inseminatedCows.remove(cow);
	}

	public Cow searchCow(String id) {
		Cow c = null;
		for (int i = 0; i < this.inseminatedCows.size(); i++) {
			if (this.inseminatedCows.get(i).getId().equals(id)) {
				c = this.inseminatedCows.get(i);
			}
		}
		return c;
	}

	public ArrayList<Cow> getInseminatedCows() {
		return this.inseminatedCows;
	}

	public void addInsemination(Cow cow, String insDay) {
		cow.setInseminationDate(insDay);
		cow.setCowstate(CowState.INSEMINATED);
	}

	public void addHeat(Cow cow, String heatDate) {
		cow.setHeatDate(heatDate);
		cow.setCowstate(CowState.MILKMAID);
	}

}
