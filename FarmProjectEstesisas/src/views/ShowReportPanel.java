package views;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Report;

public class ShowReportPanel extends JPanel {

	private MyLabel txt, chooseReport, milk, lblperformance, inventory, rentMilk, salt, preLactation;
	private JTextField litersMilk, performance, kilosRentMilk, kilosSalt, kilosPreLactation;
	private MyButton search;
	private JComboBox<Report> reports;

	public ShowReportPanel(ActionListener actionListener) {
		this.setLayout(new GridBagLayout());
		setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(900, 300));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		this.txt = new MyLabel("CONSULTAR REPORTE");
		this.chooseReport = new MyLabel("  Buscar reporte :");
		this.reports = new JComboBox<Report>();
		this.reports.setBackground(Color.WHITE);
		this.milk = new MyLabel("  Leche Producida : ");
		this.litersMilk = new JTextField(20);
		this.litersMilk.setMinimumSize(new Dimension(15,20));
		this.litersMilk.setEditable(false);
		this.lblperformance = new MyLabel("  Rendimiento ");
		this.performance = new JTextField(" 0 %");
		this.performance.setMinimumSize(new Dimension(20,20));
		this.performance.setEditable(false);
		this.inventory = new MyLabel("CONCETRADO CONSUMIDO ");
		this.rentMilk = new MyLabel("  Rentaleche : ");
		this.kilosRentMilk = new JTextField(20);
		this.kilosRentMilk.setEditable(false);
		this.salt = new MyLabel("  Sal : ");
		this.kilosSalt = new JTextField(20);
		this.kilosSalt.setEditable(false);
		this.preLactation = new MyLabel("  Prelactancia : ");
		this.kilosPreLactation = new JTextField(20);
		this.kilosPreLactation.setEditable(false);
		this.search = new MyButton(actionListener, "Consultar Reporte");
		addComponents();
	}

	private void addComponents() {
		GridBagConstraints g = new GridBagConstraints();
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 1;
		g.ipady = 10;
		g.ipadx = 30;
		this.add(this.txt, g);
		g.gridy = 1;
		
		g.ipady = 10;
		this.add(this.chooseReport, g);
		g.gridx = 2;
		g.ipady = 0;
		this.add(this.reports, g);
		g.gridx = 4;
		this.add(this.search, g);
		g.gridx = 0;
		g.gridy = 2;
		g.ipady = 20;
		this.add(this.milk, g);
		g.ipady = 0;
		g.gridx = 1;
		this.add(this.litersMilk, g);
		g.gridx = 2;
		g.gridwidth = 1;
		this.add(this.lblperformance, g);
		g.gridx = 3;
		g.gridwidth = 1;
		this.add(this.performance, g);
		g.gridx = 0;
		g.gridy = 3;
		g.gridwidth = 2;
		g.gridheight = 2;
		g.ipady = 30;
		this.add(this.inventory, g);
		g.gridx = 0;
		g.gridy = 5;
		g.gridwidth = 1;
		g.ipady = 10;
		g.ipadx = 45;
		this.add(this.rentMilk, g);
		g.gridx = 1;
		this.add(this.kilosRentMilk, g);
		g.gridx = 2;
		this.add(this.salt, g);
		g.gridx = 3;
		this.add(this.kilosSalt, g);
		g.gridx = 4;
		this.add(this.preLactation, g);
		g.gridx = 5;
		this.add(this.kilosPreLactation, g);
	}

	public void setReports(ArrayList<Report> reports) {
		this.reports.removeAllItems();
		for (int i = 0; i < reports.size(); i++) {
			this.reports.addItem(reports.get(i));
		}
	}
	
	public void addReport(Report r) {
		this.reports.addItem(r);
	}

	public Report getReportToConsult() {
		return (Report) this.reports.getSelectedItem();
	}
	
	public void setInfo() {
		Report r = (Report) this.reports.getSelectedItem();
		this.litersMilk.setText(Integer.toString(r.getLitersMilk()));
		this.performance.setText(Integer.toString(r.getPerformance()) + "%");
		this.kilosRentMilk.setText(Integer.toString(r.getInventoryConsumed().getRentMilk()));
		this.kilosSalt.setText(Integer.toString(r.getInventoryConsumed().getSalt()));
		this.kilosPreLactation.setText(Integer.toString(r.getInventoryConsumed().getPreLactation()));
	}

}