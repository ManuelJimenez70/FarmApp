package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Inventory;

public class Menu extends JPanel{

	private MyButton btnMain,btnReproduction,btnSickness,btnReports;
	private FoodLbl lblRentMilk,lblSalt,lblPreLactation;
	
	public Menu(ActionListener actionListener){
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),50));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		initButtons(actionListener);
		initLbls();
		addComponents();
	}
	
	private void addComponents() {
		GridBagConstraints g = new GridBagConstraints();
		g.ipadx=0;
		g.ipady=0;
		g.fill = g.HORIZONTAL;
		g.weightx =1;
		g.weighty =1;
		g.gridy = 0;
		g.anchor = g.WEST;
		g.insets = new Insets(0, 0, 0, 0);
		this.add(this.btnMain,g);
		g.gridx = 1;
		this.add(this.btnReproduction,g);
		g.gridx = 2;
		this.add(this.btnSickness,g);
		g.gridx = 3;
		this.add(this.btnReports,g);
		g.gridx = 4;
		g.ipadx=300;
		this.add(new JLabel("        "),g);
		g.ipadx=0;
		g.gridx = 5;
		g.anchor = g.EAST;
		g.fill = g.NONE;
		this.add(this.lblRentMilk,g);
		g.gridx = 6;
		this.add(this.lblSalt,g);
		g.gridx = 7;
		this.add(this.lblPreLactation,g);
	}

	private void initButtons(ActionListener actionListener) {
		
		this.btnMain = new MyButton(actionListener,"Principal");
		this.btnReproduction = new MyButton(actionListener,"Ctrl. Reproduccion");
		this.btnSickness = new MyButton(actionListener,"Ctrl. Enfermedades");
		this.btnReports = new MyButton(actionListener,"Reportes");
	
	}
	
	private void initLbls() {
		this.lblRentMilk = new FoodLbl("RentaLeche:  ", "resources/images/food/rentMilk.png", "La Cantidad de comida RentaLeche en Kilos");
		this.lblSalt = new FoodLbl("Sal:  ", "resources/images/food/salt.png", "La Cantidad de comida Sal en Kilos");
		this.lblPreLactation = new FoodLbl("PreLactancia: ", "resources/images/food/preLactation.png", "La Cantidad de comida PreLactancia en Kilos");
	
	}

	public void addInventory(Inventory inventory) {
		this.lblRentMilk.setQuantity(this.lblRentMilk.getQuantity() + inventory.getRentMilk());
		this.lblSalt.setQuantity(this.lblSalt.getQuantity() + inventory.getSalt());
		this.lblPreLactation.setQuantity(this.lblPreLactation.getQuantity() + inventory.getPreLactation());
	}

	public void delInventory(Inventory inventoryConsumed) {
		this.lblRentMilk.setQuantity(this.lblRentMilk.getQuantity() - inventoryConsumed.getRentMilk());
		this.lblSalt.setQuantity(this.lblSalt.getQuantity() - inventoryConsumed.getSalt());
		this.lblPreLactation.setQuantity(this.lblPreLactation.getQuantity() - inventoryConsumed.getPreLactation());		
	}

}
