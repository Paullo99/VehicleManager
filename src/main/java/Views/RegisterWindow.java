package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.FlowLayout;
import DB.JavaDB;

public class RegisterWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	//main
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterWindow frame = new RegisterWindow(null);
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
	public RegisterWindow(JFrame parentFrame) {
		setTitle("Rejestracja");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1162, 777);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnTest = new JButton("Rejestruj");
		btnTest.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				RegisterWindow.this.dispose();
				if((parentFrame!=null)) {parentFrame.show();}
			}
		});
		
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPane.add(btnTest);
	}

	/*
	 * Metoda odpowiadaj¹ca za dodanie nowego u¿ytkownika do bazy danych
	 */
	public void addNewUser() {
	    try {
	    	JavaDB database = new JavaDB();
			Connection connection = JavaDB.connectToDB();
	        Statement stat = connection.createStatement();
	        String dodajSQL = "INSERT INTO User "/*
	                + "VALUES ('',"
	                +  + ","
	                + "'" + takson.getRodzaj() + "',"
	                + "'" + takson.getGatunek() + "',"
	                + takson.getN2() + ","
	                + takson.getX() + ","
	                + "'" + takson.getUwagi() + "'" 
	                + "  );"*/;
	        stat.executeUpdate(dodajSQL);
	        stat.close();
	        connection.close();
	        // Komunikat i wydrukowanie koñcowej formy polecenia SQL
	        System.out.println("Polecenie: \n" + dodajSQL + "\n wykonane.");
	    } catch (Exception e) {
	        System.out.println("Nie mogê dodaæ danych " + e.getMessage());
	    }
	}
}

