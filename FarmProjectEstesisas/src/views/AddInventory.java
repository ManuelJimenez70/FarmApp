package views;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Inventory;

public class AddInventory extends JPanel {
	
	private MyLabel txt, rentMilk, salt ,preLactation;
	private JTextField txtFieldRentMilk, txtFieldSalt ,txtFieldPreLactation; 
	private MyButton button;

    public AddInventory(ActionListener actionListener) {
        this.setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(800, 200));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        this.txt = new MyLabel("INGRESAR INVENTARIO EN KILOS");
        this.rentMilk = new MyLabel("  Rentaleche : ");
        this.salt = new MyLabel("  Sal : ");
        this.preLactation = new MyLabel("  Prelactancia : ");
        this.txtFieldRentMilk = new JTextField(20);
        this.txtFieldRentMilk.setText("0");
        this.txtFieldSalt = new JTextField(20);
        this.txtFieldSalt.setText("0");
        this.txtFieldPreLactation = new JTextField(20);
        this.txtFieldPreLactation.setText("0");
        this.button = new MyButton(actionListener, "Agregar inventario");
        addComponents();
    }

	private void addComponents() {
		GridBagConstraints g = new GridBagConstraints();
        g.gridx = 1;
        g.gridy = 0;
        g.gridwidth = 3;
        g.ipadx = 20;
        g.ipady = 10;
        this.add(this.txt,g);
        g.gridx = 0;
        g.gridy = 1;
        g.gridwidth = 1;
        g.ipady = 15;
        this.add(this.rentMilk,g);
        g.gridx = 1;
        g.ipady = 0;
        g.ipadx = 40;
        this.add(this.txtFieldRentMilk,g);
        g.gridx = 2;
        this.add(this.salt,g);
        g.gridx = 3;
        g.ipady = 0;
        this.add(this.txtFieldSalt,g);
        g.gridx = 4;
        this.add(this.preLactation,g);
        g.gridx = 5;
        g.ipady = 0;
        this.add(this.txtFieldPreLactation,g);
        g.gridy = 2;
        g.gridx = 1;
        g.gridwidth = 3;
        g.ipady = 15;
        this.add(this.button,g);
	}
	
	public Inventory getAddInventory() {
		return new Inventory(Integer.parseInt(this.txtFieldRentMilk.getText()), Integer.parseInt(this.txtFieldSalt.getText()), Integer.parseInt(this.txtFieldPreLactation.getText()));
	}
	
	
}