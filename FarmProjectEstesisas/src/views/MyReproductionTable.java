package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import models.Cow;
import javax.swing.JLabel;
import java.awt.Font;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MyReproductionTable extends JPanel{

	private JPanel contentPane;
	private JScrollPane scrollPaneTabla;
	private JTable cowTable;
	private ArrayList<Cow> cowsInseminated;
	private MyTableModel tableModel;
	private int rows, columns;

	public MyReproductionTable() {
		setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(1000, 300));
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		JLabel lblTablaPersonas = new JLabel("Tabla Vacas");
		lblTablaPersonas.setFont(new Font("Rockwell", Font.BOLD, 25));
		contentPane.add(lblTablaPersonas, BorderLayout.NORTH);
		this.scrollPaneTabla = new JScrollPane();
		this.cowTable = new JTable();
		this.cowTable.setMinimumSize(new Dimension(800, 500));
		cowTable.setBackground(Color.WHITE);
		this.cowsInseminated = new ArrayList<Cow>();
		construirTabla();
	}

	private void construirTabla() {
		ArrayList<String> headerTitles = new ArrayList<>();
		headerTitles.add("ID o Nombre");
		headerTitles.add("Ultimo Celo");
		headerTitles.add("Fecha de Inseminación");
		headerTitles.add("Fecha de Parto");
		headerTitles.add("Proximo Celo");
		String titulos[] = new String[headerTitles.size()];
		for (int i = 0; i < titulos.length; i++) {
			titulos[i] = headerTitles.get(i);
		}
		Object[][] data = obtenerMatrizDatos(headerTitles);
		construirTabla(titulos, data);
	}

	private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {
		Object informacion[][] = new String[this.cowsInseminated.size()][titulosList.size()];
		for (int x = 0; x < informacion.length; x++) {
			informacion[x][Titles.ID] = "  "+this.cowsInseminated.get(x).getId();
			LocalDate lastheat = readLocalDate(this.cowsInseminated.get(x).getHeatDate());
			informacion[x][Titles.LASTHEATORSICKS] = "  "+lastheat.toString();
			LocalDate insDate = readLocalDate(this.cowsInseminated.get(x).getInseminationDate());
			informacion[x][Titles.INSDATEORMEDS] = "  "+this.cowsInseminated.get(x).getInseminationDate();
			LocalDate dueDate = insDate.plusDays(283);
			informacion[x][Titles.DUEDATEORSTATE] = "  "+dueDate.toString();
			LocalDate nextDue = lastheat.plusDays(21);
			informacion[x][Titles.NEXTDUE] =  "  "+nextDue.toString();
		}
		return informacion;
	}

	public LocalDate readLocalDate(String date) {
		if (!date.equals("Sin Especificar")) {
			String[] dateStrings = date.split("-");
			LocalDate localDate = LocalDate.of(Integer.parseInt(dateStrings[0]), Integer.parseInt(dateStrings[1]),
					Integer.parseInt(dateStrings[2]));
			return localDate;
		}
		return LocalDate.of(1,1,1);
	}

	private void construirTabla(String[] titulos, Object[][] data) {
		this.tableModel = new MyTableModel(data, titulos);
		this.cowTable.setModel(this.tableModel);
		this.rows = cowTable.getRowCount();
		this.columns = cowTable.getColumnCount();
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				this.cowTable.setValueAt(data[i][j], i, j);
			}
		}
		this.scrollPaneTabla.setViewportView(this.cowTable);
		this.cowTable.getTableHeader().setReorderingAllowed(false);
		JTableHeader jtableHeader = this.cowTable.getTableHeader();
		jtableHeader.setDefaultRenderer(new MyTableRender());
		this.cowTable.setTableHeader(jtableHeader);
		this.cowTable.setRequestFocusEnabled(true);
		this.cowTable.setRowHeight(25);
		this.cowTable.setGridColor(new java.awt.Color(0, 0, 0));
		this.cowTable.getColumnModel().getColumn(Titles.ID).setPreferredWidth(150);
		this.cowTable.getColumnModel().getColumn(Titles.LASTHEATORSICKS).setPreferredWidth(150);
		this.cowTable.getColumnModel().getColumn(Titles.INSDATEORMEDS).setPreferredWidth(150);
		this.cowTable.getColumnModel().getColumn(Titles.DUEDATEORSTATE).setPreferredWidth(150);
		this.cowTable.getColumnModel().getColumn(Titles.NEXTDUE).setPreferredWidth(150);
		this.add(jtableHeader, BorderLayout.NORTH);
		this.add(scrollPaneTabla, BorderLayout.CENTER);
	}
	public void setCows(ArrayList<Cow> inseminatedCows) {
		this.cowsInseminated = inseminatedCows;
		this.cowTable.clearSelection();
		construirTabla();
	}
}