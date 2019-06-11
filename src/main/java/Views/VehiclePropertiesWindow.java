package Views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DB.JavaDB;
import java.awt.Canvas;

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
		setBounds(100, 100, 1152, 781);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Typ Pojazdu:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(20, 61, 93, 14);
		contentPane.add(lblNewLabel);
		
		textFieldVehicleType = new JTextField();
		textFieldVehicleType.setEditable(false);
		textFieldVehicleType.setBounds(134, 61, 154, 20);
		contentPane.add(textFieldVehicleType);
		textFieldVehicleType.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Marka:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(20, 86, 93, 14);
		contentPane.add(lblNewLabel_1);
		
		textFieldVehicleMark = new JTextField();
		textFieldVehicleMark.setEditable(false);
		textFieldVehicleMark.setBounds(134, 86, 154, 20);
		contentPane.add(textFieldVehicleMark);
		textFieldVehicleMark.setColumns(10);
		
		textFieldVehicleModel = new JTextField();
		textFieldVehicleModel.setEditable(false);
		textFieldVehicleModel.setColumns(10);
		textFieldVehicleModel.setBounds(134, 111, 154, 20);
		contentPane.add(textFieldVehicleModel);
		
		JLabel lblNewLabel_2 = new JLabel("Model:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(30, 111, 83, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Przebieg:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(20, 136, 93, 14);
		contentPane.add(lblNewLabel_3);
		
		textFieldVehicleCourse = new JTextField();
		textFieldVehicleCourse.setEditable(false);
		textFieldVehicleCourse.setBounds(134, 136, 154, 20);
		contentPane.add(textFieldVehicleCourse);
		textFieldVehicleCourse.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Rok Produkcji:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(20, 161, 93, 14);
		contentPane.add(lblNewLabel_4);
		
		textFieldYearOfProduction = new JTextField();
		textFieldYearOfProduction.setEditable(false);
		textFieldYearOfProduction.setBounds(134, 161, 154, 20);
		contentPane.add(textFieldYearOfProduction);
		textFieldYearOfProduction.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Pojemno\u015B\u0107 silnika:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(20, 186, 93, 14);
		contentPane.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(134, 192, 154, 0);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textFieldEngineCapacity = new JTextField();
		textFieldEngineCapacity.setEditable(false);
		textFieldEngineCapacity.setBounds(134, 186, 154, 20);
		contentPane.add(textFieldEngineCapacity);
		textFieldEngineCapacity.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Moc silnika:");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(20, 211, 93, 14);
		contentPane.add(lblNewLabel_6);
		
		textFieldPower = new JTextField();
		textFieldPower.setEditable(false);
		textFieldPower.setBounds(134, 211, 154, 20);
		contentPane.add(textFieldPower);
		textFieldPower.setColumns(10);
		
		JLabel lblRodzajPaliwa = new JLabel("Rodzaj paliwa:");
		lblRodzajPaliwa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRodzajPaliwa.setBounds(20, 236, 93, 14);
		contentPane.add(lblRodzajPaliwa);
		
		textFieldFuelType = new JTextField();
		textFieldFuelType.setEditable(false);
		textFieldFuelType.setBounds(134, 236, 154, 20);
		contentPane.add(textFieldFuelType);
		textFieldFuelType.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u0141adowno\u015B\u0107:");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setBounds(20, 261, 93, 14);
		contentPane.add(lblNewLabel_7);
		
		textFieldLoad = new JTextField();
		textFieldLoad.setEditable(false);
		textFieldLoad.setBounds(134, 261, 154, 20);
		contentPane.add(textFieldLoad);
		textFieldLoad.setColumns(10);
		
		JLabel lblNumerRejestracyjny = new JLabel("Numer rejestracyjny:");
		lblNumerRejestracyjny.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumerRejestracyjny.setBounds(20, 286, 93, 14);
		contentPane.add(lblNumerRejestracyjny);
		
		textFieldRegistrationNumber = new JTextField();
		textFieldRegistrationNumber.setEditable(false);
		textFieldRegistrationNumber.setBounds(134, 286, 154, 20);
		contentPane.add(textFieldRegistrationNumber);
		textFieldRegistrationNumber.setColumns(10);
		
		/**
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
		btnAddNotice.setBounds(21, 655, 103, 35);
		contentPane.add(btnAddNotice);
		
		/**
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
		btnAddFueling.setBounds(134, 655, 103, 35);
		contentPane.add(btnAddFueling);
		
		/**
		 * Przycisk odpowiedzialny za ustawienie przypomienia 
		 */
		JButton btnReminder = new JButton("Przypomnienie");
		btnReminder.setBounds(247, 655, 103, 35);
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
		buttonDeleteVehicle.setBounds(360, 655, 103, 35);
		contentPane.add(buttonDeleteVehicle);
		
		JTextArea txtrNotices = new JTextArea();
		txtrNotices.setEditable(false);
		txtrNotices.setText("Uwagi:");
		txtrNotices.setBounds(21, 322, 267, 307);
		contentPane.add(txtrNotices);
		JLabel imgLabel = new JLabel("");
		imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    imgLabel.setBounds(298, 21, 828, 638);
		//wywo³anie metody dodaj¹cej wartoœci
		AddVehicleDataToWindow(vehicleId, imgLabel);
	    contentPane.add(imgLabel);
	}
	
	/**
	 * Funkcja dodaj¹ca dane samochodu do textboxów w oknie
	 */
	public void AddVehicleDataToWindow(int vehicleId, JLabel imgLabel){
		String imgName = "";
		try {
            Connection connection = JavaDB.connectToDB();
            Statement stat = connection.createStatement();
            /**
             * Polecenie wyszukania
             */
            String searchSQL = "SELECT * FROM Vehicle Where Id ='"+vehicleId+"';";
            ResultSet result = stat.executeQuery(searchSQL);
            System.out.println("wynik polecenia:\n" + searchSQL);
            
            /**
             * dodawanie wartoœci do textBoxów
             */
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
            	imgName=result.getString("imageUrl");
            	
             }
            imgLabel.setIcon(new ImageIcon("C:\\Users\\Kewin\\Studia\\projekt PO\\VehicleManager\\VehicleManager\\src\\main\\images\\"+imgName.trim()));
            result.close();
            stat.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Nie mogê wyszukaæ danych " + e.getMessage());
        }
	}
}
