package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ReportsPanel extends JPanel{

    private Presenter presenterReport;
    private RegisterFood registerFood;

    public ReportsPanel(ActionListener actionListener) {
        this.setLayout(new FlowLayout());
        setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(1000, 100));
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        this.presenterReport = new Presenter("resources/images/report.jpg",
                "\n\t\t REPORTES    \n  Informe y registro del consumo de concetrado y rendimiento diario\r\n"  + 
                     "  de las vacas." );
        this.registerFood = new RegisterFood(actionListener);

        this.add(this.presenterReport);
        this.add(this.registerFood);
    }

    @Override
    public void paint(java.awt.Graphics g) {
        ImageIcon i = new ImageIcon("resources/images/body.png");
        g.drawImage(i.getImage(), 0, 0, this.getSize().width, this.getSize().height, null);
        this.setOpaque(false);
        super.paint(g);
    }
}