package views;


import javax.swing.table.DefaultTableModel;


public class MyTableModel extends DefaultTableModel{
	
	String[] titulos;
	Object[][] datos;

	public MyTableModel(Object[][] datos, String[] titulos) {
		super();
		this.titulos=titulos;
		this.datos=datos;
		setDataVector(datos, titulos);
	}
	
	public MyTableModel() {
	}

	public boolean isCellEditable (int row, int column)
	{
		if (column!=Titles.LASTHEAT){   
	    	   return false; 
	       }else{
	    	   return true;
	       }
 
	}

}