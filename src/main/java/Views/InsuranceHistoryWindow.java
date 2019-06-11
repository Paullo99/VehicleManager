package Views;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DB.JavaDB;

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
		setTitle("Historia ubezpieczeñ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1296, 611);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1260, 550);
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

	
	/**
	 * Metoda odpowiadaj¹ca za pobieranie danych o ubezpieczeniu z bazy danych i dodawanie ich w formie wierszy tabeli
	 */
public void addRowToTable() {
	
	DefaultTableModel model = (DefaultTableModel) table.getModel();
	try {
        Connection connection = JavaDB.connectToDB();
        Statement stat = connection.createStatement();
        /**
         *  Polecenie wyszukania
         */
        String searchSQL = "SELECT vehicleId, type, policyNumber, expirationDate, course, price, dateOfEvent, description FROM Insurance;";
        ResultSet result = stat.executeQuery(searchSQL);
        System.out.println("wynik polecenia:\n" + searchSQL);

        /**
         * pêtla odpowiedzialna za dodawanie wierszy do tabeli
         */
        while (result.next()) {
            model.addRow(new Object[] {result.getInt("vehicleId"), result.getString("type"), result.getString("policyNumber"), result.getString("expirationDate"),
            		result.getString("course"), result.getString("price"),result.getString("dateOfEvent"), result.getString("description"),""
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
