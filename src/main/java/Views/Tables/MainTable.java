package Views.Tables;

import java.awt.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

import javax.swing.table.TableModel;
import DB.JavaDB;
import Views.VehiclePropertiesWindow;

import javax.swing.table.DefaultTableModel;

import javax.swing.table.*;

public class MainTable extends JFrame

{
	private JTable table;

	private String[] columnNames = new String[5];

	JButton button = new JButton();

	public MainTable(JPanel topPanel, JScrollPane scrollPane)
	{
		columnNames = new String[] { "Id","Typ pojazdu", "Marka pojazdu", "Model", "Numer rejestracyjny", "Wlasciwosci" };
		TableModel model = new DefaultTableModel(null, columnNames);
		table = new JTable();
		table.setModel(model);
		table.getColumnModel().getColumn(1).setWidth(10);
		table.getColumn("Wlasciwosci").setCellRenderer(new ButtonRenderer());
		table.getColumn("Wlasciwosci").setCellEditor(new ButtonEditor(new JCheckBox()));

		scrollPane.setViewportView(table);
		button.setText("Otwórz");
		/**
		 * Przycisk wywo³uj¹cy otwarcie okna z w³aœciwoœciami pojazdu
		 */
		button.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						
						int row = table.getSelectedRow();
						Object id = table.getValueAt(row, 0);
						VehiclePropertiesWindow propertiesWindow = new VehiclePropertiesWindow((int) id);
						propertiesWindow.show();
						
					}
				}
		);
		/**
		 * Wywo³anie funkcji pobieraj¹cej dane z bazy danych do tabeli
		 */
		addRowToTable();
	}
	
	/**
	 * Metoda odpowiadaj¹ca za pobieranie pojazdów z bazy danych i dodawanie ich w formie wierszy tabeli
	 */
	public void addRowToTable() {
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		try {
            Connection connection = JavaDB.connectToDB();
            Statement stat = connection.createStatement();
            /**
             *  Polecenie wyszukania
             */
            String searchSQL = "SELECT Id, vehicleType, mark, model, registrationNumber FROM Vehicle;";
            ResultSet result = stat.executeQuery(searchSQL);
            System.out.println("wynik polecenia:\n" + searchSQL);

            while (result.next()) {
                model.addRow(new Object[] {result.getInt("Id"), result.getString("vehicleType"), result.getString("mark"), result.getString("model"),
                		result.getString("registrationNumber"),""
                });
             }
            result.close();
            stat.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Nie mogê wyszukaæ danych " + e.getMessage());
        }
	}
	/**
	 * Klasa odpowiadaj¹ca za generowanie przycisku
	 */
	class ButtonRenderer extends JButton implements TableCellRenderer {
		public ButtonRenderer() {
			setOpaque(true);
		}

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			setText("Otwórz");
			return this;
		}
	}
	/**
	 * Klasa odpowiadaj¹ca za w³aœciwoœci przycisku
	 */
	class ButtonEditor extends DefaultCellEditor {
		private String label;
		
		public ButtonEditor(JCheckBox checkBox) {
			super(checkBox);
		}

		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
			return button;
		}
		
		public Object getCellEditorValue() {
			return ""; // new String(label);
		}
	}
}
