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

public class RefuellingHistoryWindow extends JFrame {

	private JPanel contentPane;
	private String[] columnNames = new String[5];
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RefuellingHistoryWindow frame = new RefuellingHistoryWindow(1);
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
	public RefuellingHistoryWindow(int vehicleId) {
		setTitle("Historia tankowañ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1296, 611);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1260, 550);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		columnNames = new String[] { "Id","Przebieg", "Cena za litr", "Iloœæ paliwa [litry]", ""
				+ "Data"};
		TableModel model = new DefaultTableModel(null, columnNames);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		addRowToTable(vehicleId);
	}
	public void addRowToTable(int vehicleId) {
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		 String searchSQL = "SELECT Id, course, price, dateOfEvent, amountOfFuel FROM Refuelling "
	        		+ "WHERE VehicleId == " + vehicleId+ ";";
		
		try {
			
	        Connection connection = JavaDB.connectToDB();
	        Statement stat = connection.createStatement();
	        /**
	         *  Polecenie wyszukania
	         */
	       
	        ResultSet result = stat.executeQuery(searchSQL);
	        System.out.println("wynik polecenia:\n" + searchSQL);

	        /**
	         * pêtla odpowiedzialna za dodawanie wierszy do tabeli
	         */
	        while (result.next()) {
	            model.addRow(new Object[] {result.getInt("Id"), result.getString("course"), result.getString("price"),
	            		result.getString("amountOfFuel"), result.getString("dateOfEvent")
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
