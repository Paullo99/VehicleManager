package Views;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DB.JavaDB;

public class ServiceHistoryWindow extends JFrame {

	
	private JPanel contentPane;

	private String[] columnNames = new String[7];
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServiceHistoryWindow frame = new ServiceHistoryWindow(1);
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
	public ServiceHistoryWindow(int vehicleId) {
		setTitle("Historia serwisów");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1296, 611);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1260, 550);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		columnNames = new String[] { "Id","Nazwa", "Data", ""
				+ "Typ", "Cena", "Przebieg", "Opis" };
		TableModel model = new DefaultTableModel(null, columnNames);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		addRowToTable(vehicleId);
		
	}

	
	/**
	 * Metoda odpowiadaj¹ca za pobieranie danych o serwisie z bazy danych i dodawanie ich w formie wierszy tabeli
	 */
public void addRowToTable(int vehicleId) {
	
	DefaultTableModel model = (DefaultTableModel) table.getModel();
	try {
        Connection connection = JavaDB.connectToDB();
        Statement stat = connection.createStatement();
        /**
         *  Polecenie wyszukania
         */
        String searchSQL = "SELECT vehicleId, name, description, type, course, price, dateOfEvent FROM Service "
        		+ "WHERE vehicleId == " + vehicleId+ ";";
        ResultSet result = stat.executeQuery(searchSQL);
        System.out.println("wynik polecenia:\n" + searchSQL);
        
        /**
         * pêtla odpowiedzialna za dodawanie nowych wierszy do tabeli
         */
        while (result.next()) {
            model.addRow(new Object[] {result.getInt("vehicleId"), result.getString("name"), result.getString("dateOfEvent"),
            		result.getString("type"), result.getString("price"),result.getString("course"), result.getString("description"),""
            });
         }
        result.close();
        stat.close();
        connection.close();
    } catch (Exception e) {
        System.out.println("Nie mogê wyszukaæ danych " + e.getMessage());
    }
	}

}
