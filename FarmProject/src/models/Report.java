package models;

import java.time.LocalDate;

public class Report {

    private LocalDate reportDate;
    private int litersMilk;
    private Inventory inventoryConsumed;

    public Report() {
		// TODO Auto-generated constructor stub
	}
    
    public Report(LocalDate reportDate) {
        super();
        this.reportDate = reportDate;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
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

	@Override
	public String toString() {
		return "Report [reportDate=" + reportDate + ", litersMilk=" + litersMilk + ", inventoryConsumed="
				+ inventoryConsumed + "]";
	}

}
