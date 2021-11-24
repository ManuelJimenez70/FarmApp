package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import models.Cow;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
		this.setPreferredSize(new Dimension(1000, 540));
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

		// se asignan las columnas al arreglo para enviarse al momento de construir la
		// tabla
		String titulos[] = new String[headerTitles.size()];
		for (int i = 0; i < titulos.length; i++) {
			titulos[i] = headerTitles.get(i);
		}
		/*
		 * obtenemos los datos de la lista y los guardamos en la matriz que luego se
		 * manda a construir la tabla
		 */
		Object[][] data = obtenerMatrizDatos(headerTitles);
		construirTabla(titulos, data);

	}

	/**
	 * Llena la información de la tabla usando la lista de personas trabajada
	 * anteriormente, guardandola en una matriz que se retorna con toda la
	 * información para luego ser asignada al modelo
	 * 
	 * @param titulosList
	 * @return
	 */
	private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {

		/*
		 * se crea la matriz donde las filas son dinamicas pues corresponde a todos los
		 * usuarios, mientras que las columnas son estaticas correspondiendo a las
		 * columnas definidas por defecto
		 */
		Object informacion[][] = new String[this.cowsInseminated.size()][titulosList.size()];
		for (int x = 0; x < informacion.length; x++) {
			informacion[x][Titles.ID] = "  "+this.cowsInseminated.get(x).getId();
			LocalDate lastheat = readLocalDate(this.cowsInseminated.get(x).getHeatDate());
			informacion[x][Titles.LASTHEAT] = "  "+lastheat.toString();
			LocalDate insDate = readLocalDate(this.cowsInseminated.get(x).getInseminationDate());
			informacion[x][Titles.INSDATE] = "  "+this.cowsInseminated.get(x).getInseminationDate();
			LocalDate dueDate = insDate.plusDays(283);
			informacion[x][Titles.DUEDATE] = "  "+dueDate.toString();
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

	/**
	 * Con los titulos y la información a mostrar se crea el modelo para poder
	 * personalizar la tabla, asignando tamaño de celdas tanto en ancho como en alto
	 * así como los tipos de datos que va a poder soportar.
	 * 
	 * @param titulos
	 * @param data
	 */
	private void construirTabla(String[] titulos, Object[][] data) {
		this.tableModel = new MyTableModel(data, titulos);
		// se asigna el modelo a la tabla
		this.cowTable.setModel(this.tableModel);

		this.rows = cowTable.getRowCount();
		this.columns = cowTable.getColumnCount();
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				this.cowTable.setValueAt(data[i][j], i, j);
			}
		}
		// se asigna la tabla al scrollPane
		this.scrollPaneTabla.setViewportView(this.cowTable);
		this.cowTable.getTableHeader().setReorderingAllowed(false);

		// personaliza el encabezado
		JTableHeader jtableHeader = this.cowTable.getTableHeader();
		jtableHeader.setDefaultRenderer(new MyTableRender());
		this.cowTable.setTableHeader(jtableHeader);
		this.cowTable.setRequestFocusEnabled(true);
		this.cowTable.setRowHeight(25);// tamaño de las celdas
		this.cowTable.setGridColor(new java.awt.Color(0, 0, 0));
		// Se define el tamaño de largo para cada columna y su contenido
		this.cowTable.getColumnModel().getColumn(Titles.ID).setPreferredWidth(150);
		this.cowTable.getColumnModel().getColumn(Titles.LASTHEAT).setPreferredWidth(150);
		this.cowTable.getColumnModel().getColumn(Titles.INSDATE).setPreferredWidth(150);
		this.cowTable.getColumnModel().getColumn(Titles.DUEDATE).setPreferredWidth(150);
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