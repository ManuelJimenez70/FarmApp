package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Calf;
import models.Cow;

public class CalfDelater extends JPanel {

	private JComboBox<Calf> calfs;
	private MyLabel lblCalf;
	private MyButton deleteCalf;
	
	public CalfDelater(ActionListener actionListener) {
		this.setLayout(new GridBagLayout());
		setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(500, 280));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		this.calfs = new JComboBox<Calf>();
		this.lblCalf = new MyLabel("Cria: ");
		this.calfs.setMinimumSize(new Dimension(300, 20));
		this.calfs.setBackground(Color.WHITE);
		this.deleteCalf = new MyButton(actionListener, "Eliminar Cria");
		addComponents();
	}
	
	private void addComponents() {
        GridBagConstraints g = new GridBagConstraints();
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 2;
        g.gridheight = 1;
        JLabel lblAdd = new JLabel("ELIMINAR CRIA: ");
        lblAdd.setBackground(Color.WHITE);
        lblAdd.setFont(new Font("Agency FB", Font.PLAIN, 20));
        lblAdd.setForeground(Color.RED);
        g.ipadx = 80;
        g.ipady = 30;
        g.anchor = g.WEST;
        this.add(lblAdd, g);
        g.ipady = 30;
        g.anchor = g.CENTER;
        g.gridy = 1;
        g.gridwidth = 1;
        this.add(this.lblCalf, g);
        g.gridx = 1;
        g.ipady = 10;
        g.gridwidth = 1;
        g.ipady = 0;
        this.add(this.calfs, g);
        g.gridx = 0;
        g.gridwidth = 2;
        g.gridy = 2;
        this.add(this.deleteCalf, g);
    }
	

	public void setCalfs(ArrayList<Calf> calfs) {
		ArrayList<Calf> cowSort = sort(calfs);
		for (int i = 0; i < cowSort.size(); i++) {
			this.calfs.addItem(cowSort.get(i));
		}
	}

	public void addCalf(Calf calf) {
		this.calfs.addItem(calf);
		ArrayList<Calf> calfs = new ArrayList<Calf>();
		for (int i = 0; i < this.calfs.getItemCount(); i++) {
			calfs.add(this.calfs.getItemAt(i));
		}
		this.calfs.removeAllItems();
		setCalfs(calfs);
	}

	public ArrayList<Calf> sort(ArrayList<Calf> calfs) {
		calfs.sort(new Comparator<Calf>() {

			@Override
			public int compare(Calf o1, Calf o2) {
				return o1.getId().compareTo(o2.getId());
			}
		});
		return calfs;
	}

	public Calf getCalfToDelete() {
		return (Calf) this.calfs.getSelectedItem();
	}

	public void deleteCalf(Calf calf) {
		ArrayList<Calf> calfs = new ArrayList<Calf>();
		for (int i = 0; i < this.calfs.getItemCount(); i++) {
			calfs.add(this.calfs.getItemAt(i));
		}
		calfs.remove(calf);
		this.calfs.removeAllItems();
		setCalfs(calfs);
	}
}
