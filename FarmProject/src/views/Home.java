package views;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import models.Breed;
import models.Calf;
import models.Cow;

public class Home extends JPanel {

	private Presenter presenter;
	private Register register;
	private CowSearcher cowSearcher;
	private Aditor aditor;
	private Deleter deleter;


	public Home(ActionListener actionListener) {
		this.setLayout(new FlowLayout());
		setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(1000, 1630));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		this.presenter = new Presenter("resources/images/cow.png","\n\tBIENVENIDO	\n  ¡Deseamos resolver los problemas estructurales en cuanto al manejo y\r\n" + 
				"  organización en la producción y desarrollo de la industria láctea!");
		this.register = new Register(actionListener);
		this.cowSearcher = new CowSearcher(actionListener);
		this.aditor = new Aditor(actionListener);
		this.deleter = new Deleter(actionListener);

		this.add(this.presenter);
		this.add(this.register);
		this.add(this.cowSearcher);
		this.add(this.aditor);
		this.add(this.deleter);
	}
	
	@Override
	public void paint(Graphics g) {
		ImageIcon i = new ImageIcon("resources/images/body.png");
		g.drawImage(i.getImage(), 0, 0, this.getSize().width, this.getSize().height, null);
		this.setOpaque(false);
		super.paint(g);
	}

	public void setCows(ArrayList<Cow> cows) {
		this.cowSearcher.setCows(cows);
		this.deleter.setCows(cows);
	}
	
	public void setInfo(Cow cow) {
		this.cowSearcher.setInfo(cow);
	}

	public Cow getCowInfo() {
		return this.cowSearcher.getCowInfo();
	}
	
	public void setBreeds(ArrayList<Breed> breeds) {
		this.aditor.setBreeds(breeds);
	}
	
	public Breed getBreed() {
		return this.aditor.getBreed();
	}
	
	public String getNewCowId() {
		return this.aditor.getNewCowId();
	}

	public Cow getCowToDelete() {
		return this.deleter.getCowToDelete();
	}

	public void setCalfs(ArrayList<Calf> calfs) {
		this.deleter.setCalfs(calfs);
	}

	public void addCalf(Calf calf) {
		this.deleter.addCalf(calf);
	}

	public Calf getCalfToDelete() {
		return this.deleter.getCalfToDelete();
	}

	public void deleteCalf(Calf calf) {
		this.deleter.deleteCalf(calf);
	}
	
}
