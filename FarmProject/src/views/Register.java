package views;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Register extends JPanel {

	private RegisterPanel reports, reproduction, sicks;

	public Register(ActionListener actionListener) {
		this.setLayout(new GridLayout(1, 3));
		setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(1000, 500));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		this.reports = new RegisterPanel(actionListener, "resources/images/reports.png", " Generar Reporte\n\n Se genera un reporte diario en el\n que se indica la fecha, los litros de\n leche producidos y el inventario\n consumido", "Reportes");
		this.reproduction = new RegisterPanel(actionListener, "resources/images/reproduction.png", " Control de Reproduccion\n\n Muestra fechas sobre el proceso\n de gestación de los bovinos\n con respecto a las inseminaciones\n y calores",
				"Ctrl. Reproduccion");
		this.sicks = new RegisterPanel(actionListener, "resources/images/sicks.png", " Control de Enfermedades\n\nMuestra una lista de ganado\nenfermo con su respectivo \ntratamiento ",
				"Ctrl. Enfermedades");
		this.add(this.reports);
		this.add(this.reproduction);
		this.add(this.sicks);

	}
}
