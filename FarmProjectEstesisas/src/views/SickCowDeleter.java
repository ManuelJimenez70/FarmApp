package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import models.Cow;

public class SickCowDeleter extends JPanel{
	
	private JComboBox<Cow> cows;
	private MyLabel lblCow, lblDelete;
	private MyButton button;

	public SickCowDeleter(ActionListener actionListener) {
		this.setLayout(new GridBagLayout());
		setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(600, 250));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		this.lblDelete = new MyLabel("ELIMINAR VACA ENFERMA");
		this.lblCow = new MyLabel("Vaca : ");
		this.cows = new JComboBox<Cow>();
		this.cows.setBackground(Color.WHITE);
		this.button = new MyButton(actionListener, "Eliminar Vaca Enferma");
		addComponents();	
	}

	public void addComponents() {
		GridBagConstraints g = new GridBagConstraints();
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 2;
		g.gridheight = 1;
		this.add(this.lblDelete,g);
		g.ipady = 50;
		g.ipadx =10;
		g.gridy = 1;
		g.gridwidth = 1;
		this.add(this.lblCow,g);
		g.gridx = 1;
		g.ipady = 0;
		this.add(this.cows,g);
		g.ipady = 0;
		g.gridx = 1;
		g.gridy = 2;
		this.add(this.button,g);
	}
	
	
	public void setSickCows(ArrayList<Cow> cows) {
        this.cows.removeAllItems();
        for (int i = 0; i < cows.size(); i++) {
            this.cows.addItem(cows.get(i));
        }
    }

	public Cow getCowHealthy() {
		return (Cow) this.cows.getSelectedItem();
	}
}
