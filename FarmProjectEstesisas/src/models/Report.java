package models;

import java.time.LocalDate;

public class Report {

    private String reportDate;
    private int litersMilk;
    private Inventory inventoryConsumed;
    private double performance;

    public Report() {
    	this.reportDate = "2000-01-01";
        this.litersMilk = 0;
        this.inventoryConsumed = new Inventory(0, 0, 0);
        this.performance = 0;
    }
    
    public Report(String reportDate) {
        super();
        this.reportDate = reportDate;
        this.litersMilk = 0;
        this.inventoryConsumed = new Inventory(0, 0, 0);
        this.performance = 0;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public int getLitersMilk() {
        return litersMilk;
    }

    public void setLitersMilk(int litersMilk) {
        this.litersMilk = litersMilk;
    }

    public Inventory getInventoryConsumed() {
        return inventoryConsumed;
    }

    public void setInventoryConsumed(Inventory inventoryConsumed) {
        this.inventoryConsumed = inventoryConsumed;
    }
    
    public void setInventoryConsumed(int rentMilk,int salt,int preLactation) {
        this.inventoryConsumed = new Inventory(rentMilk, salt, preLactation);
    }

	@Override
	public String toString() {
		return this.reportDate;
	}
	
	public void setPerformance(int promMilk) {
		this.performance = (this.litersMilk * 100)/promMilk;
	}

	public int getPerformance() {
		return (int) this.performance;
	}

}
