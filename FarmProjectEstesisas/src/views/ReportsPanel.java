package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import models.Inventory;
import models.Report;

public class ReportsPanel extends JPanel{

    private Presenter presenterReport;
    private RegisterReport registerReport;
    private AddInventory addInventory;
    private ShowReportPanel showReportPanel;

    public ReportsPanel(ActionListener actionListener) {
        this.setLayout(new FlowLayout());
        setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(1000, 1200));
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        this.presenterReport = new Presenter("resources/images/report.jpg",
                "\n\t\t REPORTES    \n  Informe y registro del consumo de concetrado y rendimiento diario\r\n"  + 
                     "  de las vacas." );
        this.registerReport = new RegisterReport(actionListener);
        this.addInventory = new AddInventory(actionListener);
        this.showReportPanel = new ShowReportPanel(actionListener);
        this.add(this.presenterReport);
        this.add(this.addInventory);
        this.add(this.registerReport);
        this.add(this.showReportPanel);
    }

    @Override
    public void paint(java.awt.Graphics g) {
        ImageIcon i = new ImageIcon("resources/images/body.png");
        g.drawImage(i.getImage(), 0, 0, this.getSize().width, this.getSize().height, null);
        this.setOpaque(false);
        super.paint(g);
    }

	public Report getReport() {
		return this.registerReport.getReport();
	}

	public void setReports(ArrayList<Report> reports) {
		this.showReportPanel.setReports(reports);
	}
	
	public void addReport(Report r) {
		this.showReportPanel.addReport(r);
	}

	public void setInfoReport() {
		this.showReportPanel.setInfo();	
	}
	
	public Inventory getAddInventory() {
		return this.addInventory.getAddInventory();
	}
}