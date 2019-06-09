package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import com.toedter.calendar.JCalendar;
import javax.swing.JButton;
import java.awt.Font;

public class AddNewInsuranceWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTypeOfInsurance;
	private JTextField textFieldPolicyNumber;
	private JTextField textFieldDescriptionOfInsurance;
	private JTextField textFieldCourseDuringInsurance;
	private JTextField textFieldPriceOfInsurance;
	private JTextField textFieldVehicleId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewInsuranceWindow frame = new AddNewInsuranceWindow();
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
	public AddNewInsuranceWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldTypeOfInsurance = new JTextField();
		textFieldTypeOfInsurance.setBounds(112, 36, 86, 20);
		contentPane.add(textFieldTypeOfInsurance);
		textFieldTypeOfInsurance.setColumns(10);
		
		textFieldPolicyNumber = new JTextField();
		textFieldPolicyNumber.setColumns(10);
		textFieldPolicyNumber.setBounds(112, 67, 86, 20);
		contentPane.add(textFieldPolicyNumber);
		
		textFieldDescriptionOfInsurance = new JTextField();
		textFieldDescriptionOfInsurance.setColumns(10);
		textFieldDescriptionOfInsurance.setBounds(112, 98, 86, 20);
		contentPane.add(textFieldDescriptionOfInsurance);
		
		textFieldCourseDuringInsurance = new JTextField();
		textFieldCourseDuringInsurance.setColumns(10);
		textFieldCourseDuringInsurance.setBounds(112, 129, 86, 20);
		contentPane.add(textFieldCourseDuringInsurance);
		
		textFieldPriceOfInsurance = new JTextField();
		textFieldPriceOfInsurance.setColumns(10);
		textFieldPriceOfInsurance.setBounds(112, 160, 86, 20);
		contentPane.add(textFieldPriceOfInsurance);
		
		textFieldVehicleId = new JTextField();
		textFieldVehicleId.setColumns(10);
		textFieldVehicleId.setBounds(112, 191, 86, 20);
		contentPane.add(textFieldVehicleId);
		
		JLabel lblNewLabel = new JLabel("Rodzaj:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 39, 77, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNumerPolisy = new JLabel("Numer Polisy:");
		lblNumerPolisy.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumerPolisy.setBounds(10, 70, 77, 14);
		contentPane.add(lblNumerPolisy);
		
		JLabel lblOpis = new JLabel("Opis:");
		lblOpis.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOpis.setBounds(10, 101, 77, 14);
		contentPane.add(lblOpis);
		
		JLabel lblPrzebieg = new JLabel("Przebieg:");
		lblPrzebieg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrzebieg.setBounds(10, 132, 77, 14);
		contentPane.add(lblPrzebieg);
		
		JLabel lblKoszt = new JLabel("Koszt:");
		lblKoszt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKoszt.setBounds(10, 163, 77, 14);
		contentPane.add(lblKoszt);
		
		JLabel lblVehicleid = new JLabel("VehicleId");
		lblVehicleid.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVehicleid.setBounds(10, 194, 77, 14);
		contentPane.add(lblVehicleid);
		
		JCalendar calendarStartOfInsurance = new JCalendar();
		calendarStartOfInsurance.setBounds(245, 55, 152, 153);
		contentPane.add(calendarStartOfInsurance);
		
		JLabel lblDataWykupienia = new JLabel("Data wykupienia:");
		lblDataWykupienia.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataWykupienia.setBounds(245, 30, 152, 14);
		contentPane.add(lblDataWykupienia);
		
		JCalendar calendarExpirationDateOfInsurance = new JCalendar();
		calendarExpirationDateOfInsurance.setBounds(431, 55, 152, 153);
		contentPane.add(calendarExpirationDateOfInsurance);
		
		JLabel lblDataWyganicia = new JLabel("Data wyga\u015Bni\u0119cia:");
		lblDataWyganicia.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataWyganicia.setBounds(431, 30, 152, 14);
		contentPane.add(lblDataWyganicia);
		
		JButton btnConfirmNewInsurance = new JButton("Zatwierdz");
		btnConfirmNewInsurance.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnConfirmNewInsurance.setBounds(245, 280, 152, 77);
		contentPane.add(btnConfirmNewInsurance);
	}
}
