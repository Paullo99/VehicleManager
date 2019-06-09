package Views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Views.ButtonInJTable.ButtonEditor;
import Views.ButtonInJTable.ButtonRenderer;

public class InsuranceHistoryWindow extends JFrame {

	private String[] columnNames = new String[8];
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsuranceHistoryWindow frame = new InsuranceHistoryWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InsuranceHistoryWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 964, 566);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 928, 505);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		columnNames = new String[] { "Id","Typ ubezpieczenia", "Numer polisy", " Data wa¿noœci polisy", ""
				+ "Przebieg", "Cena", "Data", "Opis" };
		TableModel model = new DefaultTableModel(null, columnNames);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		addRowToTable();
		
	}

	
	/*
	 * Metoda odpowiadaj¹ca za pobieranie danych o ubezpieczeniu z bazy danych i dodawanie ich w formie wierszy tabeli
	 */
public void addRowToTable() {
	DefaultTableModel model = (DefaultTableModel) table.getModel();
}
}