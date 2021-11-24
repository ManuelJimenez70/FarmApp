package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Presenter extends JPanel {

    private JLabel icon;
    private JTextArea descripcion;

    public Presenter(String imageDirection, String txt) {
        this.setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(1000, 200));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        initComponents(imageDirection, txt);
    }

    private void initComponents(String imageDirection, String txt) {
        this.icon = new JLabel(new ImageIcon(imageDirection));
        this.add(this.icon,BorderLayout.WEST);
        this.descripcion = new JTextArea(txt);
        this.descripcion.setFont(new Font("Agency FB", Font.PLAIN, 24));
        this.descripcion.setEditable(false);
        this.add(this.descripcion,BorderLayout.CENTER);
    }
}
