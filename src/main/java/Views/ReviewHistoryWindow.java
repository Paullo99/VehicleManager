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

public class ReviewHistoryWindow extends JFrame {

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
					ReviewHistoryWindow frame = new ReviewHistoryWindow();
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
	public ReviewHistoryWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1296, 611);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1260, 550);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		columnNames = new String[] { "Id","Czy przeszed³?", "Data wa¿noœci", ""
				+ "Przebieg", "Cena", "Data", "Uwagi" };
		TableModel model = new DefaultTableModel(null, columnNames);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		addRowToTable();
		
	}

	
	/*
	 * Metoda odpowiadaj¹ca za pobieranie danych o przegl¹dach z bazy danych i dodawanie ich w formie wierszy tabeli
	 */
public void addRowToTable() {
	
	DefaultTableModel model = (DefaultTableModel) table.getModel();
	try {
        Connection connection = JavaDB.connectToDB();
        Statement stat = connection.createStatement();
        // Polecenie wyszukania
        String searchSQL = "SELECT vehicleId, isPassed, notices, expirationDate, course, price, dateOfEvent FROM Review;";
        ResultSet result = stat.executeQuery(searchSQL);
        System.out.println("wynik polecenia:\n" + searchSQL);

        while (result.next()) {
            model.addRow(new Object[] {result.getInt("vehicleId"), result.getString("isPassed"), result.getString("expirationDate"),
            		result.getString("course"), result.getString("price"),result.getString("dateOfEvent"), result.getString("notices"),""
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
