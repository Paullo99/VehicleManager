package Views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Classes.Vehicle;
import DB.JavaDB;

public class AddVehicleWindow extends JFrame {

	private JPanel contentPaneLoad;
	private JTextField textFieldMark;
	private JTextField textFieldModel;
	private JTextField textFieldCourse;
	private JTextField textFieldYearOfProduction;
	private JTextField textFieldEngineCapacity;
	private JTextField textFieldPower;
	private JTextField textFieldLoad;
	private JTextField textFieldImageUrl;
	private JTextField textFieldRegistrationNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddVehicleWindow frame = new AddVehicleWindow();
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
	public AddVehicleWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1162, 777);
		setLocationRelativeTo(null);
		contentPaneLoad = new JPanel();
		contentPaneLoad.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneLoad);
		contentPaneLoad.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Rodzaj pojazdu:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(284, 28, 138, 33);
		contentPaneLoad.add(lblNewLabel);
		
		JComboBox comboBoxVehicleType = new JComboBox();
		comboBoxVehicleType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxVehicleType.setModel(new DefaultComboBoxModel(new String[] {"Samoch\u00F3d osobowy", "Samoch\u00F3d ci\u0119\u017Carowy", "Motocykl"}));
		comboBoxVehicleType.setBounds(466, 28, 187, 26);
		contentPaneLoad.add(comboBoxVehicleType);
		
		JLabel lblMarka = new JLabel("Marka:");
		lblMarka.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMarka.setBounds(284, 87, 138, 33);
		contentPaneLoad.add(lblMarka);
		
		textFieldMark = new JTextField();
		textFieldMark.setBounds(466, 88, 187, 28);
		contentPaneLoad.add(textFieldMark);
		textFieldMark.setColumns(10);
		
		JLabel lblModel = new JLabel("Model:");
		lblModel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModel.setBounds(284, 152, 138, 26);
		contentPaneLoad.add(lblModel);
		
		textFieldModel = new JTextField();
		textFieldModel.setColumns(10);
		textFieldModel.setBounds(466, 150, 187, 28);
		contentPaneLoad.add(textFieldModel);
		
		JLabel lblPrzebieg = new JLabel("Przebieg:");
		lblPrzebieg.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrzebieg.setBounds(284, 212, 138, 26);
		contentPaneLoad.add(lblPrzebieg);
		
		textFieldCourse = new JTextField();
		textFieldCourse.setColumns(10);
		textFieldCourse.setBounds(466, 207, 187, 28);
		contentPaneLoad.add(textFieldCourse);
		
		JLabel lblDataProdukcji = new JLabel("Rok produkcji:");
		lblDataProdukcji.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataProdukcji.setBounds(284, 272, 138, 26);
		contentPaneLoad.add(lblDataProdukcji);
		
		textFieldYearOfProduction = new JTextField();
		textFieldYearOfProduction.setColumns(10);
		textFieldYearOfProduction.setBounds(466, 269, 187, 28);
		contentPaneLoad.add(textFieldYearOfProduction);
		
		JLabel lblPojemnoSilnikal = new JLabel("Pojemno\u015B\u0107 silnika [litr]:");
		lblPojemnoSilnikal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPojemnoSilnikal.setBounds(284, 332, 170, 26);
		contentPaneLoad.add(lblPojemnoSilnikal);
		
		textFieldEngineCapacity = new JTextField();
		textFieldEngineCapacity.setColumns(10);
		textFieldEngineCapacity.setBounds(466, 329, 187, 28);
		contentPaneLoad.add(textFieldEngineCapacity);
		
		JLabel lblMocSilnikakm = new JLabel("Moc silnika [KM]:");
		lblMocSilnikakm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMocSilnikakm.setBounds(284, 388, 170, 26);
		contentPaneLoad.add(lblMocSilnikakm);
		
		textFieldPower = new JTextField();
		textFieldPower.setColumns(10);
		textFieldPower.setBounds(466, 388, 187, 28);
		contentPaneLoad.add(textFieldPower);
		
		JLabel lblRodzajPaliwa = new JLabel("Rodzaj paliwa:");
		lblRodzajPaliwa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRodzajPaliwa.setBounds(284, 454, 170, 26);
		contentPaneLoad.add(lblRodzajPaliwa);
		
		JComboBox comboBoxFuelType = new JComboBox();
		comboBoxFuelType.setModel(new DefaultComboBoxModel(new String[] {"Benzyna", "Diesel", "Gaz", "Inne"}));
		comboBoxFuelType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxFuelType.setBounds(466, 454, 187, 26);
		contentPaneLoad.add(comboBoxFuelType);
		
		JLabel lbladowno = new JLabel("\u0141adowno\u015B\u0107:");
		lbladowno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbladowno.setBounds(284, 515, 170, 26);
		contentPaneLoad.add(lbladowno);
		
		textFieldLoad = new JTextField();
		textFieldLoad.setColumns(10);
		textFieldLoad.setBounds(466, 513, 187, 28);
		contentPaneLoad.add(textFieldLoad);
		
		JLabel lblZdjciehttp = new JLabel("Zdj\u0119cie:");
		lblZdjciehttp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblZdjciehttp.setBounds(284, 575, 170, 26);
		contentPaneLoad.add(lblZdjciehttp);
		
		textFieldImageUrl = new JTextField();
		textFieldImageUrl.setColumns(10);
		textFieldImageUrl.setBounds(466, 575, 187, 28);
		contentPaneLoad.add(textFieldImageUrl);
		
		JLabel lblNumerRejestracyjny = new JLabel("Numer rejestracyjny:");
		lblNumerRejestracyjny.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumerRejestracyjny.setBounds(284, 627, 170, 26);
		contentPaneLoad.add(lblNumerRejestracyjny);
		
		textFieldRegistrationNumber = new JTextField();
		textFieldRegistrationNumber.setColumns(10);
		textFieldRegistrationNumber.setBounds(466, 632, 187, 28);
		contentPaneLoad.add(textFieldRegistrationNumber);
		
		JButton btnAddVehicle = new JButton("Dodaj pojazd");
		//dodawanie nowego pojazdu po klikniêciu przycisku Dodaj pojazd
		btnAddVehicle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//tworzenie obiektu
				Vehicle vehicle = new Vehicle(0, comboBoxVehicleType.getSelectedItem().toString(),textFieldMark.getText(),textFieldModel.getText(),
						textFieldCourse.getText(), Integer.parseInt(textFieldYearOfProduction.getText()), textFieldEngineCapacity.getText(),
						Integer.parseInt(textFieldPower.getText()),comboBoxFuelType.getSelectedItem().toString(), Integer.parseInt(textFieldLoad.getText()),
						textFieldImageUrl.getText(), textFieldRegistrationNumber.getText());
				
				addNewVehicle(vehicle);
				//zamkniêcie bie¿¹cego okna i otwarcie poprzedniego
				AddVehicleWindow.this.dispose();
			}
		});
		
		
		btnAddVehicle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddVehicle.setBounds(284, 693, 369, 23);
		contentPaneLoad.add(btnAddVehicle);
	}
	
	/*
	 * Metoda odpowiadaj¹ca za dodanie nowego pojazdu do bazy danych
	 */
	public void addNewVehicle(Vehicle vehicle){
	    try {
			Connection connection = JavaDB.connectToDB();
	        Statement stat = connection.createStatement();
	        String SQL = "INSERT INTO Vehicle "
	                + "VALUES (NULL,"
	                + "'" + vehicle.getVehicleType() + "',"
	                + "'" + vehicle.getMark() + "',"
	                + "'" + vehicle.getModel() + "',"
	                + "'" + vehicle.getCourse() + "',"
	                + "'" + vehicle.getYearOfProduction() + "',"
	                + "'" + vehicle.getEngineCapacity() + "',"
	                + "'" + vehicle.getPower() + "',"
	                + "'" + vehicle.getFuelType() + "',"
	                + "'" + vehicle.getLoad() + "',"
	                + "'" + vehicle.getImageUrl() + "',"
	                + "'" + vehicle.getRegistrationNumber()+ "'"
	                + ");";
	        System.out.println(SQL);
	        stat.executeUpdate(SQL);
	        stat.close();
	        connection.close();
	        // Komunikat i wydrukowanie koñcowej formy polecenia SQL
	        System.out.println("Polecenie: \n" + SQL + "\n wykonane.");
	    } catch (Exception e) {
	        System.out.println("Nie mogê dodaæ danych " + e.getMessage());
	    }
	}
}
