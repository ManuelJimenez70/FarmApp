package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import models.Calf;
import models.Cow;
import models.CowState;

public class ReproductorPanel extends JPanel {

	private Presenter presenterReproductor;
	private RegisterDates registerInsemation;
	private RegisterDates registerLastHeat;
	private AditorCalf aditorCalf;
	private CowStatePanel cowStatePanel;
	private MyReproductionTable inseminationTable;
	
	public ReproductorPanel(ActionListener actionListener) {
		this.setLayout(new FlowLayout());
		setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(1000, 1530));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		this.presenterReproductor = new Presenter("resources/images/cowandcalf.png",
				"\n\tCONTROL DE REPRODUCCION    \n  ˇImplementación y manejo de registros que se consideran importantes\r\n"
						+ "   para el proceso de gestación y reproduccion de los bovinos.");
		this.registerInsemation = new RegisterDates(actionListener, "<html> AGREGAR FECHA DE INSEMINACION<html>","resources/images/insemination.jpg","Agregar Inseminacion");
		this.registerLastHeat =  new RegisterDates(actionListener, "<html>AGREGAR FECHA DEL ULTIMO CELO<html>", "resources/images/heat.jpg", "Agregar Ultimo Celo");
		this.aditorCalf = new AditorCalf(actionListener);
		this.cowStatePanel = new CowStatePanel(actionListener);
		this.inseminationTable = new MyReproductionTable();
		this.add(this.presenterReproductor);
		this.add(this.aditorCalf);
		this.add(this.registerLastHeat);
		this.add(this.registerInsemation);
		this.add(this.cowStatePanel);
		this.add(this.inseminationTable);
	}

	@Override
	public void paint(java.awt.Graphics g) {
		ImageIcon i = new ImageIcon("resources/images/body.png");
		g.drawImage(i.getImage(), 0, 0, this.getSize().width, this.getSize().height, null);
		this.setOpaque(false);
		super.paint(g);
	}

	public void setCows(ArrayList<Cow> cows) {
		this.aditorCalf.setCows(cows);
		this.registerInsemation.setCows(cows);
		this.registerLastHeat.setCows(cows);
		this.cowStatePanel.setCows(cows);
		this.inseminationTable.setCows(setCowsInseminated(cows));
	}

	public ArrayList<Cow> setCowsInseminated(ArrayList<Cow> cows) {
		ArrayList<Cow> inseminatedCows = new ArrayList<Cow>();
		for (int i = 0; i < cows.size(); i++) {
			if (cows.get(i).getCowstate()!= null && cows.get(i).getCowstate().equals(CowState.INSEMINATED)) {
				inseminatedCows.add(cows.get(i));
			} 
		}
		return inseminatedCows;
	}
	
	public Calf getNewCalf() {
		return this.aditorCalf.getNewCalf();
	}
	
	public String getDateInsemination() {
		return this.registerInsemation.getDate();
	}
	
	public String getDateHeat() {
		return this.registerLastHeat.getDate();
	}
	
	public Cow getCowtoHeat() {
		return this.registerLastHeat.getCowTo();
	}
	
	public Cow getCowtoInsemination() {
		return this.registerInsemation.getCowTo();
	}
	
	public CowState getCowState() {
		return this.cowStatePanel.getCowState();
	}
	
	public Cow getCow() {
		return this.cowStatePanel.getCow();
	}

}
