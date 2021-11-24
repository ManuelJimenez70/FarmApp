package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Cow;

public class AddDiseasePanel extends JPanel{

    private MyLabel txt, cow, thingAdd;
    private JLabel icon;
    private JComboBox<Cow> sicksCows;
    private JTextField txtAdd;
    private MyButton button;

    public AddDiseasePanel(ActionListener actionListener, String txt, String thingAdd,String icon, String button) {
        this.setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(400, 400));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        initComponents(actionListener, txt,thingAdd,icon, button);
    }

    private void initComponents(ActionListener actionListener, String txt, String thingAdd,String icon, String button) {
        this.txt = new MyLabel(txt);
        this.cow = new MyLabel("Vaca : ");
        this.thingAdd = new MyLabel(thingAdd);
        this.icon = new JLabel(new ImageIcon(icon));
        this.sicksCows = new JComboBox<Cow>();
        this.txtAdd = new JTextField(10);
        this.button = new MyButton(actionListener, button);
        this.button.setActionCommand(button);

        GridBagConstraints g = new GridBagConstraints();
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth =2;
        g.gridheight=2;
        this.add(this.icon, g);
        g.ipady = 30;
        g.ipadx = 5;
        g.gridheight=1;
        g.gridy =2;
        this.add(this.txt,g);
        g.ipady = 0;
        g.gridwidth =1;
        g.gridy = 3;
        g.ipady = 15;
        this.add(this.cow, g);
        g.gridx = 1;
        g.ipady = 0;
        this.add(this.sicksCows, g);
        g.gridx =0;
        g.gridy =4;
        g.ipady = 15;
        this.add(this.thingAdd,g);
        g.gridx =1;
        g.ipady = 0;
        this.add(this.txtAdd, g);
        g.gridx = 0; 
        g.gridwidth = 2;
        g.gridy =5;
        this.add(this.button, g);
    }

    public Cow getSickCow() {
		return (Cow) this.sicksCows.getSelectedItem();
    }
    
    public JComboBox<Cow> getSickCows() {
		return this.sicksCows;
    }
    
    public String getString() {
    	return this.txtAdd.getText();
    }
}