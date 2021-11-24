package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import models.Cow;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MyDiseaseTable extends JPanel {
	private JPanel contentPane;
	private JScrollPane scrollPaneTabla;
	private JTable cowTable;
	private ArrayList<Cow> cowsSicks;
	private MyTableModel tableModel;
	private int rows, columns;

	public MyDiseaseTable() {
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
		this.cowsSicks = new ArrayList<Cow>();
		buildTable();
	}

	private void buildTable() {
		ArrayList<String> headerTitles = new ArrayList<>();
		headerTitles.add("ID o Nombre");
		headerTitles.add("Enfermedades");
		headerTitles.add("Medicina Aplicada");
		headerTitles.add("Estado");
		String titulos[] = new String[headerTitles.size()];
		for (int i = 0; i < titulos.length; i++) {
			titulos[i] = headerTitles.get(i);
		}
		Object[][] data = getData(headerTitles);
		buildTable(titulos, data);
	}

	private Object[][] getData(ArrayList<String> titulosList) {
		Object informacion[][] = new String[this.cowsSicks.size()][titulosList.size()];
		for (int x = 0; x < informacion.length; x++) {
			informacion[x][Titles.ID] = "  " + this.cowsSicks.get(x).getId();
			informacion[x][Titles.LASTHEATORSICKS] = "  " + sumStrings(this.cowsSicks.get(x).getDiseases());
			informacion[x][Titles.INSDATEORMEDS] = "  " + sumStrings(this.cowsSicks.get(x).getMedicineApplied());
			informacion[x][Titles.DUEDATEORSTATE] = "  " + this.cowsSicks.get(x).getCowstate().name();
		}
		return informacion;
	}

	public String sumStrings(ArrayList<String> strings) {
		String s = "";
		for (int i = 0; i < strings.size(); i++) {
			if (i < strings.size() - 1) {
				s += strings.get(i) + ", ";
			}else {
				s += strings.get(i);
			}
		}
		return s;
	}

	private void buildTable(String[] titles, Object[][] data) {
		this.tableModel = new MyTableModel(data, titles);
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
		this.add(jtableHeader, BorderLayout.NORTH);
		this.add(scrollPaneTabla, BorderLayout.CENTER);
	}

	public void setList() {
		for (int i = 0; i < this.cowsSicks.size(); i++) {
			Cow sick = this.cowsSicks.get(i);
	        ArrayList<String> sicks = sick.getDiseases();
	        Set<String> hashSet = new HashSet<String>(sicks);
	        sicks.clear();
	        sicks.addAll(hashSet);
	        sick.setDiseases(sicks);	
		}
    }

	public void setCows(ArrayList<Cow> cowsSick) {
		this.cowsSicks = cowsSick;
		setList();
		buildTable();
	}
}
