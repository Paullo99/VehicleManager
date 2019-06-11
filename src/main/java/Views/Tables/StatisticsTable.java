package Views.Tables;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import DB.JavaDB;
import Views.ServicesWindow;

public class StatisticsTable extends JTable{
	private JTable table;
	private String[] columnNames = new String[6];
	private JButton button = new JButton();

	public StatisticsTable(JPanel topPanel, JScrollPane scrollPane)
	{
		columnNames = new String[] { "Id", "Marka pojazdu", "Model", "Numer rejestracyjny", "Spalanie", "Szczegó³y" };
		TableModel model = new DefaultTableModel(null, columnNames);
		table = new JTable();
		table.setModel(model);
		table.getColumnModel().getColumn(1).setWidth(10);
		table.getColumn("Szczegó³y").setCellRenderer(new ButtonRenderer());
		table.getColumn("Szczegó³y").setCellEditor(new ButtonEditor(new JCheckBox()));

		scrollPane.setViewportView(table);
		button.setText("Otwórz");
		/**
		 * Przycisk wywo³uj¹cy otwarcie okna z w³aœciwoœciami pojazdu
		 */
		button.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						System.out.println("Stat xd");
						int row = table.getSelectedRow();
						Object id = table.getValueAt(row, 0);
						ServicesWindow servicesWindow = new ServicesWindow((int) id);
						servicesWindow.show();
					}
				}
		);
		//Wywo³anie funkcji pobieraj¹cej dane z bazy danych do tabeli
		addRowToTable();
	}
	
	/**
	 * Metoda odpowiadaj¹ca za pobieranie pojazdów z bazy danych i dodawanie ich w formie wierszy tabeli
	 */
	private void addRowToTable() {
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		try {
            Connection connection = JavaDB.connectToDB();
            Statement stat = connection.createStatement();
            // Polecenie wyszukania
            String searchSQL = "SELECT Id, mark, model, registrationNumber FROM Vehicle;";
            ResultSet result = stat.executeQuery(searchSQL);
            System.out.println("wynik polecenia:\n" + searchSQL);

            while (result.next()) {
                model.addRow(new Object[] {result.getInt("Id"), result.getString("mark"), result.getString("model"),
                		result.getString("registrationNumber"),"",""
                });
             }
            result.close();
            stat.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Nie mogê wyszukaæ danych " + e.getMessage());
        }
	}
	/*
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
	/*
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

