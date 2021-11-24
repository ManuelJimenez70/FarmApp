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
	
	public String getInseminationDate() {
		return this.body.getInseminationDate();
	}

	public Cow getCowInseminated() {
		return this.body.getCowInseminated();
	}

	public void addInsemination(Cow cowInseminated) {
		this.body.addInsemination(cowInseminated);
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
}
