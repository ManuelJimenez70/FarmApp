package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import models.Breed;
import models.Calf;
import models.Cow;
import models.CowState;
import models.Inventory;
import models.Report;

public class View extends JFrame {

	private Menu menu;
	private Body body;

	public View(ActionListener actionListener) {
		super("Farm App");
		this.setSize(new Dimension(1300,(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		initComponents(actionListener);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void initComponents(ActionListener actionListener) {
		this.menu = new Menu(actionListener);
		this.body = new Body(actionListener);

		add(menu, BorderLayout.NORTH);
		this.add(this.body, BorderLayout.CENTER);
	}

	public void setCows(ArrayList<Cow> cows) {
		this.body.setCows(cows);
	}
	
	public void setInfoSearcher(Cow cow) {
		this.body.setInfoSearcher(cow);
	}

	public void addCow(Cow cow) {
		this.body.addCow(cow);
	}
	
	public Cow getCowInfo() {
		return this.body.getCowInfo();
	}
	
	public void setBreeds(ArrayList<Breed> breeds) {
		this.body.setBreeds(breeds);
	}
	
	public Breed getBreed() {
		return this.body.getBreed();
	}
	
	public String getNewCowId() {
		return this.body.getNewCowId();
	}

	public Cow getCowToDelete() {
		return this.body.getCowToDelete();
	}

	public void deleteCow(Cow cow) {
		this.body.deleteCow(cow);
	}
	
	public void setCalfs(ArrayList<Calf> calfs) {
		this.body.setCalfs(calfs);
	}

	public void addCalf(Calf calf) {
		this.body.addCalf(calf);
	}

	public Calf getCalfToDelete() {
		return this.body.getCalfToDelete();
	}

	public void deleteCalf(Calf calf) {
		this.body.deleteCalf(calf);
	}

	public Body getBody() {
		return this.body;
	}

	public Calf getNewCalf() {
		return this.body.getNewCalf();
	}
	
	public String getDateIntamination() {
		return this.body.getDate();
	}
	
	public Cow getCowtoInsemination() {
		return this.body.getCowtoInsemination();
	}
	
	public void addInsemination(Cow cowInsemination) {
		this.body.addInsemination(cowInsemination);
	}
	
	public void addDateHeat(Cow cow, String date) {
		this.body.addDateHeat(cow, date);
	}
	
	public String getDateHeat() {
		return this.body.getDateHeat();
	}
	
	public Cow getCowtoHeat() {
		return this.body.getCowtoHeat();
	}
	
	public CowState getCowState() {
		return this.body.getCowState();
	}
	
	public Cow getCow() {
		return this.body.getCow();
	}
	
	public void changeState(Cow cow, CowState cowState) {
		this.body.changeState(cow, cowState);
	}
	
	public Cow getCowWithSick() {
        return this.body.getCowWithSick();
    }

    public Cow getCowWithMed() {
        return this.body.getCowWithMed();
    }

    public void addSick(Cow cowWithSick) {
        this.body.addSick(cowWithSick);
    }

    public void addMedicament(Cow cowWithMed) {
        this.body.addMedicament(cowWithMed);

    }

	public Cow getCowHealthy() {
		return this.body.getCowHealthy();
	}

	public void deleteSickCow(Cow cowHealthy) {
		this.body.deleteSickCow(cowHealthy);
	}

	public Report getReport() {
		return this.body.getReport();
	}

	public void setReports(ArrayList<Report> reports) {
		this.body.setReports(reports);
	}
	
	public void addReport(Report r) {
		this.body.addReport(r);
	}

	public void setInfoReport() {
		this.body.setInfoReport();
	}
	
	public Inventory getAddInventory() {
		return this.body.getAddInventory();
	}

	public void addInventory(Inventory inventory) {
		this.menu.addInventory(inventory);
	}

	public void delInventory(Inventory inventoryConsumed) {
		this.menu.delInventory(inventoryConsumed);
		
	}
}
