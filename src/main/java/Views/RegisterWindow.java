package Views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DB.JavaDB;

public class RegisterWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldLogin;
	private JTextField textFieldPassword;
	private JTextField textFieldVorname;
	private JTextField textFieldName;
	private JTextField textFieldPhone;
	private JTextField textFieldEmail;
	private JTextField textFieldCountry;
	private JTextField textFieldCounty;
	private JTextField textFieldCity;
	private JTextField textFieldStreet;
	private JTextField textFieldNumberOfBuilding;
	private JTextField textFieldPostCode;
	private JTextField textFieldNip;
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
		btnTest.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTest.setBounds(701, 633, 119, 44);
		btnTest.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				RegisterWindow.this.dispose();
				if((parentFrame!=null)) {parentFrame.show();}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnTest);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(450, 52, 174, 20);
		contentPane.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(325, 55, 46, 14);
		contentPane.add(lblLogin);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(450, 96, 174, 20);
		contentPane.add(textFieldPassword);
		
		textFieldVorname = new JTextField();
		textFieldVorname.setColumns(10);
		textFieldVorname.setBounds(450, 213, 174, 20);
		contentPane.add(textFieldVorname);
		
		JLabel lblPassword = new JLabel("Has\u0142o:");
		lblPassword.setBounds(325, 99, 62, 14);
		contentPane.add(lblPassword);
		
		JLabel lblImi = new JLabel("Imi\u0119");
		lblImi.setBounds(325, 216, 62, 14);
		contentPane.add(lblImi);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(450, 244, 174, 20);
		contentPane.add(textFieldName);
		
		JLabel lblNazwisko = new JLabel("Nazwisko:");
		lblNazwisko.setBounds(325, 247, 62, 14);
		contentPane.add(lblNazwisko);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(450, 275, 174, 20);
		contentPane.add(textFieldPhone);
		
		JLabel lblNrTelefonu = new JLabel("Nr telefonu:");
		lblNrTelefonu.setBounds(325, 278, 62, 14);
		contentPane.add(lblNrTelefonu);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(450, 306, 174, 20);
		contentPane.add(textFieldEmail);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(325, 309, 62, 14);
		contentPane.add(lblEmail);
		
		textFieldCountry = new JTextField();
		textFieldCountry.setColumns(10);
		textFieldCountry.setBounds(450, 337, 174, 20);
		contentPane.add(textFieldCountry);
		
		JLabel lblPastwo = new JLabel("Pa\u0144stwo:");
		lblPastwo.setBounds(325, 340, 62, 14);
		contentPane.add(lblPastwo);
		
		textFieldCounty = new JTextField();
		textFieldCounty.setColumns(10);
		textFieldCounty.setBounds(450, 368, 174, 20);
		contentPane.add(textFieldCounty);
		
		JLabel lblWojewdztwo = new JLabel("Wojew\u00F3dztwo");
		lblWojewdztwo.setBounds(325, 371, 92, 14);
		contentPane.add(lblWojewdztwo);
		
		textFieldCity = new JTextField();
		textFieldCity.setColumns(10);
		textFieldCity.setBounds(450, 399, 174, 20);
		contentPane.add(textFieldCity);
		
		JLabel lblMiejscowo = new JLabel("Miejscowo\u015B\u0107");
		lblMiejscowo.setBounds(325, 402, 92, 14);
		contentPane.add(lblMiejscowo);
		
		textFieldStreet = new JTextField();
		textFieldStreet.setColumns(10);
		textFieldStreet.setBounds(450, 430, 174, 20);
		contentPane.add(textFieldStreet);
		
		JLabel lblUlica = new JLabel("Ulica:");
		lblUlica.setBounds(325, 433, 92, 14);
		contentPane.add(lblUlica);
		
		textFieldNumberOfBuilding = new JTextField();
		textFieldNumberOfBuilding.setColumns(10);
		textFieldNumberOfBuilding.setBounds(450, 461, 174, 20);
		contentPane.add(textFieldNumberOfBuilding);
		
		JLabel lblNrDomu = new JLabel("Nr domu");
		lblNrDomu.setBounds(325, 464, 92, 14);
		contentPane.add(lblNrDomu);
		
		textFieldPostCode = new JTextField();
		textFieldPostCode.setColumns(10);
		textFieldPostCode.setBounds(450, 492, 174, 20);
		contentPane.add(textFieldPostCode);
		
		JLabel lblKodPocztowy = new JLabel("Kod pocztowy");
		lblKodPocztowy.setBounds(325, 495, 92, 14);
		contentPane.add(lblKodPocztowy);
		
		JRadioButton rdbtnCompany = new JRadioButton("Firma");
		rdbtnCompany.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textFieldName.hide();
			}
		});
		rdbtnCompany.setBounds(325, 163, 109, 23);
		contentPane.add(rdbtnCompany);
		
		JRadioButton rdbtnPhysicalUser = new JRadioButton("Osoba fizyczna");
		rdbtnPhysicalUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		rdbtnPhysicalUser.setSelected(true);
		rdbtnPhysicalUser.setBounds(506, 163, 109, 23);
		contentPane.add(rdbtnPhysicalUser);
		
		ButtonGroup typeOfProfile = new ButtonGroup();
		typeOfProfile.add(rdbtnPhysicalUser);
		typeOfProfile.add(rdbtnCompany);
		
		textFieldNip = new JTextField();
		textFieldNip.setColumns(10);
		textFieldNip.setBounds(450, 535, 174, 20);
		contentPane.add(textFieldNip);
		
		textFieldNip.hide();
		
		
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

