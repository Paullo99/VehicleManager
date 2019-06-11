package Views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import Classes.Refuelling;
import DB.JavaDB;

public class AddNewRefuellingWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCours;
	private JTextField textFieldPriceOfFuel;
	private JTextField textFieldAmountOfFuel;
	private JTextField textFieldVehicleId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewRefuellingWindow frame = new AddNewRefuellingWindow(null);
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
	public AddNewRefuellingWindow(JFrame parentFrame) {
		setTitle("Dodaj nowe tankowanie");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 541, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldCours = new JTextField();
		textFieldCours.setBounds(133, 39, 86, 20);
		contentPane.add(textFieldCours);
		textFieldCours.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cena za litr:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setBounds(10, 73, 94, 14);
		contentPane.add(lblNewLabel);
		
		textFieldPriceOfFuel = new JTextField();
		textFieldPriceOfFuel.setBounds(133, 70, 86, 20);
		contentPane.add(textFieldPriceOfFuel);
		textFieldPriceOfFuel.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Przebieg:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(10, 42, 94, 14);
		contentPane.add(lblNewLabel_1);
		
		textFieldAmountOfFuel = new JTextField();
		textFieldAmountOfFuel.setBounds(133, 101, 86, 20);
		contentPane.add(textFieldAmountOfFuel);
		textFieldAmountOfFuel.setColumns(10);
		
		JLabel lblIloPaliwaW = new JLabel("Ilo\u015B\u0107 paliwa:");
		lblIloPaliwaW.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIloPaliwaW.setBounds(10, 104, 94, 14);
		contentPane.add(lblIloPaliwaW);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(10, 211, 46, 14);
		contentPane.add(lblData);
		
		JCalendar CalendarOfRefuelling = new JCalendar();
		CalendarOfRefuelling.setBounds(68, 149, 189, 172);
		contentPane.add(CalendarOfRefuelling);

		/**
		 * Przycisk odpowiedzialny za dodanie nowego tankowania
		 */
		JButton btnNewButton = new JButton("Zatwierdz");
		btnNewButton.addMouseListener(new MouseAdapter() {
			/**
			 * Tworzenie nowego obiektu klasy Refuelling
			 */
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Refuelling refuellingData = new Refuelling(textFieldCours.getText(), textFieldPriceOfFuel.getText(), textFieldAmountOfFuel.getText(), CalendarOfRefuelling.getDate(), Integer.parseInt(textFieldVehicleId.getText()));
						AddNewRefuelling(refuellingData);
			}
			
			/**
			 * Metoda odpowiadaj¹ca za dodanie nowego tankowania do bazy danych
			 */
			private void AddNewRefuelling(Refuelling refuellingData) {
				try {
					Connection connection = JavaDB.connectToDB();
			        Statement stat = connection.createStatement();
			        String SQL = "INSERT INTO Refuelling "
			                + "VALUES (NULL,"
			                + "'" + refuellingData.getCourse() + "',"
			                + "'" + refuellingData.getPrice() + "',"
			                + "'" + refuellingData.getAmountOfFuel() + "',"
			                + "'" + refuellingData.getDateOfEvent() + "',"
			                + "'" + refuellingData.getAmountOfFuel() + "'"
			                + ");";
			        System.out.println(SQL);
			        stat.executeUpdate(SQL);
			        stat.close();
			        connection.close();
			        /**
			         *  Komunikat i wydrukowanie koñcowej formy polecenia SQL
			         */
			        System.out.println("Polecenie: \n" + SQL + "\n wykonane.");
			    } catch (Exception e) {
			        System.out.println("Nie mogê dodaæ danych " + e.getMessage());
			    }
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(293, 226, 201, 62);
		contentPane.add(btnNewButton);
		
		textFieldVehicleId = new JTextField();
		textFieldVehicleId.setText("Id samochodu");
		textFieldVehicleId.setBounds(342, 39, 86, 20);
		contentPane.add(textFieldVehicleId);
		textFieldVehicleId.setColumns(10);
		
		JLabel lblL = new JLabel("[ L ]");
		lblL.setBounds(229, 104, 46, 14);
		contentPane.add(lblL);
		
		JLabel lblzl = new JLabel("[ z\u0142/L ]");
		lblzl.setBounds(229, 73, 46, 14);
		contentPane.add(lblzl);
		
		JLabel lblkm = new JLabel("[ km ]");
		lblkm.setBounds(229, 42, 46, 14);
		contentPane.add(lblkm);
		
		
	}
}
