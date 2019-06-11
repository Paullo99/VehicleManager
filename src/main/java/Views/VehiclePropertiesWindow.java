package Views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import DB.JavaDB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VehiclePropertiesWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldVehicleType;
	private JTextField textFieldVehicleMark;
	private JTextField textFieldVehicleModel;
	private JTextField textFieldVehicleCourse;
	private JTextField textFieldYearOfProduction;
	private JTextField textField;
	private JTextField textFieldEngineCapacity;
	private JTextField textFieldPower;
	private JTextField textFieldFuelType;
	private JTextField textFieldLoad;
	private JTextField textFieldRegistrationNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VehiclePropertiesWindow frame = new VehiclePropertiesWindow(1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame, argument is id
	 */
	public VehiclePropertiesWindow(int vehicleId) {
		setTitle("W³aœciwoœci pojazdu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 720, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Typ Pojazdu:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(45, 61, 68, 14);
		contentPane.add(lblNewLabel);
		
		textFieldVehicleType = new JTextField();
		textFieldVehicleType.setEditable(false);
		textFieldVehicleType.setBounds(123, 58, 86, 20);
		contentPane.add(textFieldVehicleType);
		textFieldVehicleType.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Marka:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(67, 86, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textFieldVehicleMark = new JTextField();
		textFieldVehicleMark.setEditable(false);
		textFieldVehicleMark.setBounds(123, 83, 86, 20);
		contentPane.add(textFieldVehicleMark);
		textFieldVehicleMark.setColumns(10);
		
		textFieldVehicleModel = new JTextField();
		textFieldVehicleModel.setEditable(false);
		textFieldVehicleModel.setColumns(10);
		textFieldVehicleModel.setBounds(123, 108, 86, 20);
		contentPane.add(textFieldVehicleModel);
		
		JLabel lblNewLabel_2 = new JLabel("Model:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(81, 111, 32, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Przebieg:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(67, 136, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		textFieldVehicleCourse = new JTextField();
		textFieldVehicleCourse.setEditable(false);
		textFieldVehicleCourse.setBounds(123, 133, 86, 20);
		contentPane.add(textFieldVehicleCourse);
		textFieldVehicleCourse.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Rok Produkcji:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(45, 161, 68, 14);
		contentPane.add(lblNewLabel_4);
		
		textFieldYearOfProduction = new JTextField();
		textFieldYearOfProduction.setEditable(false);
		textFieldYearOfProduction.setBounds(123, 158, 86, 20);
		contentPane.add(textFieldYearOfProduction);
		textFieldYearOfProduction.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Pojemno\u015B\u0107 silnika:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(21, 186, 92, 14);
		contentPane.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(123, 189, 68, 0);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textFieldEngineCapacity = new JTextField();
		textFieldEngineCapacity.setEditable(false);
		textFieldEngineCapacity.setBounds(123, 183, 86, 20);
		contentPane.add(textFieldEngineCapacity);
		textFieldEngineCapacity.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Moc silnika:");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(52, 211, 61, 14);
		contentPane.add(lblNewLabel_6);
		
		textFieldPower = new JTextField();
		textFieldPower.setEditable(false);
		textFieldPower.setBounds(123, 208, 86, 20);
		contentPane.add(textFieldPower);
		textFieldPower.setColumns(10);
		
		JLabel lblRodzajPaliwa = new JLabel("Rodzaj paliwa:");
		lblRodzajPaliwa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRodzajPaliwa.setBounds(31, 236, 82, 14);
		contentPane.add(lblRodzajPaliwa);
		
		textFieldFuelType = new JTextField();
		textFieldFuelType.setEditable(false);
		textFieldFuelType.setBounds(123, 233, 86, 20);
		contentPane.add(textFieldFuelType);
		textFieldFuelType.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u0141adowno\u015B\u0107:");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setBounds(52, 261, 61, 14);
		contentPane.add(lblNewLabel_7);
		
		textFieldLoad = new JTextField();
		textFieldLoad.setEditable(false);
		textFieldLoad.setBounds(123, 258, 86, 20);
		contentPane.add(textFieldLoad);
		textFieldLoad.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Tu b\u0119dzie zdj\u0119cie:");
		lblNewLabel_8.setBounds(260, 35, 126, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNumerRejestracyjny = new JLabel("Numer rejestracyjny:");
		lblNumerRejestracyjny.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumerRejestracyjny.setBounds(10, 286, 103, 14);
		contentPane.add(lblNumerRejestracyjny);
		
		textFieldRegistrationNumber = new JTextField();
		textFieldRegistrationNumber.setEditable(false);
		textFieldRegistrationNumber.setBounds(123, 283, 86, 20);
		contentPane.add(textFieldRegistrationNumber);
		textFieldRegistrationNumber.setColumns(10);
		
		/*
		 * Przycisk odpowiedzialny za dodawanie uwagi
		 */
		JButton btnAddNotice = new JButton("Dodaj uwag\u0119");
		btnAddNotice.addMouseListener(new MouseAdapter() {
		});
		btnAddNotice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddNoticeWindow noticeWindow = new AddNoticeWindow();
				noticeWindow.show();
			}
		});
		btnAddNotice.setBounds(34, 360, 103, 35);
		contentPane.add(btnAddNotice);
		
		/*
		 * Przycisk odpowiedzilany za dodawanie tankowania
		 */
		JButton btnAddFueling = new JButton("<html> <center> Dodaj <br> tankowanie </html>");
		btnAddFueling.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddNewRefuellingWindow refuellingWindow = new AddNewRefuellingWindow(null);
				refuellingWindow.show();
			}
		});
		btnAddFueling.setBounds(147, 360, 103, 35);
		contentPane.add(btnAddFueling);
		
		/*
		 * Przycisk odpowiedzialny za ustawienie przypomienia 
		 */
		JButton btnReminder = new JButton("Przypomnienie");
		btnReminder.setBounds(260, 360, 103, 35);
		contentPane.add(btnReminder);
		/**
		 * przycisk uruchamiaj¹cy usuwanie pojazdu
		 */
		JButton buttonDeleteVehicle = new JButton("Usu\u0144 pojazd");
		buttonDeleteVehicle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JavaDB.delete(vehicleId, "Vehicle")){
					JOptionPane.showMessageDialog(null,"<html> Usuniêto pojazd </html>");
					VehiclePropertiesWindow.this.dispose();
				}
			}
		});
		buttonDeleteVehicle.setBounds(373, 360, 103, 35);
		contentPane.add(buttonDeleteVehicle);
		
		JTextArea txtrNotices = new JTextArea();
		txtrNotices.setEditable(false);
		txtrNotices.setText("Uwagi:");
		txtrNotices.setBounds(480, 61, 186, 242);
		contentPane.add(txtrNotices);
		//wywo³anie metody dodaj¹cej wartoœci
		AddVehicleDataToWindow(vehicleId);
	}
	
	/**
	 * Funkcja dodaj¹ca dane samochodu do textboxów w oknie
	 */
	public void AddVehicleDataToWindow(int vehicleId){
		try {
            Connection connection = JavaDB.connectToDB();
            Statement stat = connection.createStatement();
            // Polecenie wyszukania
            String searchSQL = "SELECT * FROM Vehicle Where Id ='"+vehicleId+"';";

            ResultSet result = stat.executeQuery(searchSQL);
            System.out.println("wynik polecenia:\n" + searchSQL);
            
            //dodawanie wartoœci do textBoxów
            while (result.next()) {
            	textFieldVehicleType.setText(result.getString("vehicleType"));
            	textFieldVehicleMark.setText(result.getString("mark"));
            	textFieldVehicleModel.setText(result.getString("model"));
            	textFieldYearOfProduction.setText(result.getString("yearOfProduction"));
            	textFieldVehicleCourse.setText(result.getString("course"));
            	textFieldEngineCapacity.setText(result.getString("engineCapacity"));
            	textFieldPower.setText(result.getString("power"));
            	textFieldFuelType.setText(result.getString("fuellType"));
            	textFieldLoad.setText(result.getString("load"));
            	textFieldRegistrationNumber.setText(result.getString("registrationNumber"));
             }
            result.close();
            stat.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Nie mogê wyszukaæ danych " + e.getMessage());
        }
	}
}
