package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import models.Report;

public class RegisterReport extends JPanel{

    private MyLabel txt, dayNow;
    private MyFood rentMilk, salt ,preLactation, milk;
    private MyButton button;

    public RegisterReport(ActionListener actionListener) {
        this.setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(900, 390));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        this.txt = new MyLabel("REGISTRAR CONCENTRADO Y LECHE PRODUCIDA HOY : ");
        this.dayNow = new MyLabel(getDate() + "  /  " + getTime().substring(0, 5));
        this.rentMilk = new MyFood("resources/images/food/rentMilk.png", "RentaLeche", "Kilos : ");
        this.salt = new MyFood("resources/images/food/salt.png", "Sal", "Kilos : ");
        this.preLactation = new MyFood("resources/images/food/preLactation.png", "PreLactancia", "Kilos : ");
        this.milk = new MyFood("resources/images/food/milk.jpg","Leche producida","Litros : ");
        this.button = new MyButton(actionListener, "Generar Reporte");
        addComponents();
    }
    
    public void addComponents() {
        GridBagConstraints g = new GridBagConstraints();
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 4;
        g.ipady = 30;
        this.add(txt,g);
        g.gridx = 4;
        g.gridy = 0;
        g.gridwidth = 1;
        g.ipady = 10;
        this.add(dayNow,g);
        g.gridwidth = 2;
        g.gridx =0;
        g.gridy=1;
        this.add(rentMilk, g);
        g.gridx=3;
        this.add(salt, g);
        g.gridx=5;
        this.add(preLactation, g);
        g.gridx =2;
        g.gridy=2;
        this.add(this.milk, g);
        g.gridx = 3;
        g.gridy= 3;
        g.ipady = 0;
        this.add(this.button, g);
    }

    public String getDate() {
        LocalDate lc = LocalDate.now();
        lc.format(DateTimeFormatter.ISO_DATE);
        return lc.toString();
    }
    
    public String getTime() {
    	LocalTime lt = LocalTime.now();
    	return lt.toString();
    }

	public Report getReport() {
		Report r = new Report(this.getDate() + "  /  "+this.getTime().substring(0, 5));
		r.setLitersMilk(this.milk.getQuantity());
		r.setInventoryConsumed(this.rentMilk.getQuantity(), this.salt.getQuantity(), this.preLactation.getQuantity());
		return r;
	}

}