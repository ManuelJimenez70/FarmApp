package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class RegisterFood extends JPanel{

    private MyLabel txt, dayNow;
    private MyFood rentMilk, salt ,preLactation;
    private MyButton button;

    public RegisterFood(ActionListener actionListener) {
        this.setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(840, 300));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        this.txt = new MyLabel("REGISTRAR CONSENTRADO CONSUMIDO HOY : ");
        this.dayNow = new MyLabel(initDate().toString());
        this.rentMilk = new MyFood("resources/images/food/rentMilk.png", "RentaLeche");
        this.salt = new MyFood("resources/images/food/salt.png", "Sal");
        this.preLactation = new MyFood("resources/images/food/preLactation.png", "PreLactancia");
        this.button = new MyButton(actionListener, "Registrar");

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
        g.gridx = 3;
        g.gridy= 2;
        g.ipady = 0;
        this.add(this.button, g);
    }

    public LocalDate initDate() {
        LocalDate lc = LocalDate.now();
        return lc;
    }
}