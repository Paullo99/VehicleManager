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

import Classes.Service;
import DB.JavaDB;

public class AddNewServiceWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNameOfService;
	private JTextField textFieldDescriptionOfService;
	private JTextField textFieldTypeOfService;
	private JTextField textFieldCourseOfService;
	private JTextField textFieldPriceOfService;
	private JTextField textFieldVegicleIdOfService;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewServiceWindow frame = new AddNewServiceWindow();
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
	public AddNewServiceWindow() {
		setTitle("Dodaj nowy serwis");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 488, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nazwa");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 44, 67, 14);
		contentPane.add(lblNewLabel);
		
		textFieldNameOfService = new JTextField();
		textFieldNameOfService.setBounds(87, 41, 86, 20);
		contentPane.add(textFieldNameOfService);
		textFieldNameOfService.setColumns(10);
		
		JLabel lblOpis = new JLabel("Opis:");
		lblOpis.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOpis.setBounds(10, 72, 67, 14);
		contentPane.add(lblOpis);
		
		textFieldDescriptionOfService = new JTextField();
		textFieldDescriptionOfService.setColumns(10);
		textFieldDescriptionOfService.setBounds(87, 69, 86, 20);
		contentPane.add(textFieldDescriptionOfService);
		
		JLabel lblTyp = new JLabel("Typ:");
		lblTyp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTyp.setBounds(10, 100, 67, 14);
		contentPane.add(lblTyp);
		
		textFieldTypeOfService = new JTextField();
		textFieldTypeOfService.setColumns(10);
		textFieldTypeOfService.setBounds(87, 97, 86, 20);
		contentPane.add(textFieldTypeOfService);
		
		JLabel lblPrzebieg = new JLabel("Przebieg:");
		lblPrzebieg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrzebieg.setBounds(10, 128, 67, 14);
		contentPane.add(lblPrzebieg);
		
		textFieldCourseOfService = new JTextField();
		textFieldCourseOfService.setColumns(10);
		textFieldCourseOfService.setBounds(87, 125, 86, 20);
		contentPane.add(textFieldCourseOfService);
		
		JLabel lblCena = new JLabel("Cena:");
		lblCena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCena.setBounds(10, 156, 67, 14);
		contentPane.add(lblCena);
		
		textFieldPriceOfService = new JTextField();
		textFieldPriceOfService.setColumns(10);
		textFieldPriceOfService.setBounds(87, 153, 86, 20);
		contentPane.add(textFieldPriceOfService);
		
		JLabel lblVehicleid = new JLabel("VehicleId:");
		lblVehicleid.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVehicleid.setBounds(10, 184, 67, 14);
		contentPane.add(lblVehicleid);
		
		textFieldVegicleIdOfService = new JTextField();
		textFieldVegicleIdOfService.setColumns(10);
		textFieldVegicleIdOfService.setBounds(87, 181, 86, 20);
		contentPane.add(textFieldVegicleIdOfService);
		
		JLabel lblData = new JLabel("Data us\u0142ugi:");
		lblData.setBounds(293, 19, 67, 14);
		contentPane.add(lblData);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(257, 44, 152, 153);
		contentPane.add(calendar);
		
		/**
		 * Przycisk odpowiedzialny za dodawanie us³ugi
		 */
		JButton btnAddNewService = new JButton("Dodaj us\u0142ug\u0119");
		btnAddNewService.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/**
				 * Tworzenie nowego obiektu serwisu
				 */
				Service serviceData = new Service(textFieldNameOfService.getText(), textFieldDescriptionOfService.getText(), textFieldTypeOfService.getText(),textFieldCourseOfService.getText(), textFieldPriceOfService.getText(), calendar.getDate(),Integer.parseInt(textFieldVegicleIdOfService.getText()));
				AddNewService(serviceData);
			}
			/**
			 * Dodawanie nowego serwisu do bazy danych
			 */
				private void AddNewService(Service serviceData) {
					try {
						Connection connection = JavaDB.connectToDB();
				        Statement stat = connection.createStatement();
				        String SQL = "INSERT INTO Service "
				                + "VALUES (NULL,"
				                + "'" + serviceData.getName() + "',"
				                + "'" + serviceData.getDescription() + "',"
				                + "'" + serviceData.getType() + "',"
				                + "'" + serviceData.getCourse() + "',"
				                + "'" + serviceData.getPrice() + "',"
				                + "'" + serviceData.getDateOfEvent() + "',"
				                + "'" + serviceData.getVehicleId() + "'"
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
		btnAddNewService.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddNewService.setBounds(175, 252, 125, 51);
		contentPane.add(btnAddNewService);
	}
}
