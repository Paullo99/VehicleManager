package Views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Classes.Company;
import Classes.PhysicalUser;
import Classes.Profile;
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
	private JTextField textFieldPesel;
	private JTextField textFieldFirmName;
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
	@SuppressWarnings("deprecation")
	public RegisterWindow(JFrame parentFrame) {
		setTitle("Rejestracja");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1162, 777);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnRegister = new JButton("Rejestruj");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegister.setBounds(701, 633, 119, 44);
		
		contentPane.setLayout(null);
		contentPane.add(btnRegister);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(450, 111, 174, 20);
		contentPane.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(325, 114, 46, 14);
		contentPane.add(lblLogin);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(450, 136, 174, 20);
		contentPane.add(textFieldPassword);
		
		textFieldVorname = new JTextField();
		textFieldVorname.setColumns(10);
		textFieldVorname.setBounds(450, 213, 174, 20);
		contentPane.add(textFieldVorname);
		
		JLabel lblPassword = new JLabel("Has\u0142o:");
		lblPassword.setBounds(325, 139, 62, 14);
		contentPane.add(lblPassword);
		
		JLabel lblName = new JLabel("Imi\u0119:");
		lblName.setBounds(325, 216, 62, 14);
		contentPane.add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(450, 244, 174, 20);
		contentPane.add(textFieldName);
		
		JLabel lblSurname = new JLabel("Nazwisko:");
		lblSurname.setBounds(325, 247, 62, 14);
		contentPane.add(lblSurname);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(450, 275, 174, 20);
		contentPane.add(textFieldPhone);
		
		JLabel lblNrTelefonu = new JLabel("Nr telefonu:");
		lblNrTelefonu.setBounds(325, 278, 77, 14);
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
		
		JLabel lblWojewdztwo = new JLabel("Wojew\u00F3dztwo:");
		lblWojewdztwo.setBounds(325, 371, 92, 14);
		contentPane.add(lblWojewdztwo);
		
		textFieldCity = new JTextField();
		textFieldCity.setColumns(10);
		textFieldCity.setBounds(450, 399, 174, 20);
		contentPane.add(textFieldCity);
		
		JLabel lblMiejscowo = new JLabel("Miejscowo\u015B\u0107:");
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
		
		JLabel lblNrDomu = new JLabel("Nr domu:");
		lblNrDomu.setBounds(325, 464, 92, 14);
		contentPane.add(lblNrDomu);
		
		textFieldPostCode = new JTextField();
		textFieldPostCode.setColumns(10);
		textFieldPostCode.setBounds(450, 492, 174, 20);
		contentPane.add(textFieldPostCode);
		
		JLabel lblKodPocztowy = new JLabel("Kod pocztowy:");
		lblKodPocztowy.setBounds(325, 495, 102, 17);
		contentPane.add(lblKodPocztowy);
		
		JLabel lblPesel = new JLabel("PESEL:");
		lblPesel.setBounds(325, 526, 92, 14);
		contentPane.add(lblPesel);
		
		JLabel lblNi = new JLabel("NIP:");
		lblNi.setBounds(325, 247, 92, 14);
		contentPane.add(lblNi);
		lblNi.hide();
		
		JLabel lblFirmName = new JLabel("Nazwa:");
		lblFirmName.setBounds(325, 216, 92, 14);
		contentPane.add(lblFirmName);
		lblFirmName.hide();
		
		textFieldNip = new JTextField();
		textFieldNip.setColumns(10);
		textFieldNip.setBounds(450, 244, 174, 20);
		contentPane.add(textFieldNip);
		textFieldNip.hide();
		
		textFieldPesel = new JTextField();
		textFieldPesel.setColumns(10);
		textFieldPesel.setBounds(450, 523, 174, 20);
		contentPane.add(textFieldPesel);
		
		textFieldFirmName = new JTextField();
		textFieldFirmName.setColumns(10);
		textFieldFirmName.setBounds(450, 213, 174, 20);
		contentPane.add(textFieldFirmName);
		textFieldFirmName.hide();
		
		textFieldNip.hide();
		
		//radio button odpowiadaj¹cy za ukrywanie pól dla u¿ytkowników a pokazywanie dla firm
		JRadioButton rdbtnCompany = new JRadioButton("Firma");
		rdbtnCompany.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textFieldName.hide();
				textFieldVorname.hide();
				textFieldPesel.hide();
				textFieldNip.show();
				lblName.hide();
				lblSurname.hide();
				lblPesel.hide();
				textFieldFirmName.show();
				lblNi.show();
				lblFirmName.show();
			
			}
		});
		rdbtnCompany.setBounds(531, 175, 109, 23);
		contentPane.add(rdbtnCompany);
		
		//radio button odpowiadaj¹cy za ukrywanie pól dla firm a pokazywanie dla u¿ytkowników
		JRadioButton rdbtnPhysicalUser = new JRadioButton("Osoba fizyczna");
		rdbtnPhysicalUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textFieldName.show();
				textFieldVorname.show();
				textFieldPesel.show();
				textFieldNip.hide();
				lblName.show();
				lblSurname.show();
				lblPesel.show();
				textFieldFirmName.hide();
				lblNi.hide();
				lblFirmName.hide();
			}
		});
		rdbtnPhysicalUser.setSelected(true);
		rdbtnPhysicalUser.setBounds(382, 175, 109, 23);
		contentPane.add(rdbtnPhysicalUser);
		
		ButtonGroup typeOfProfile = new ButtonGroup();
		typeOfProfile.add(rdbtnPhysicalUser);
		typeOfProfile.add(rdbtnCompany);
		
		//dodawanie nowego u¿ytkownika po klikniêciu przycisku Zarejestruj
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(rdbtnPhysicalUser.isSelected()) {
					//pobieranie daty z PESELU
					char[] pesel = textFieldPesel.getText().toCharArray();
					int year = Integer.parseInt(""+pesel[0]+pesel[1]);
					int month = Integer.parseInt(""+pesel[2]+pesel[3])-1;
					int day = Integer.parseInt(""+pesel[4]+pesel[5]);
					Date dateOfBirth = new Date(year, month, day);
					
					//tworzenie obiektu 
					PhysicalUser userData = new PhysicalUser( textFieldVorname.getText(), textFieldName.getText(), dateOfBirth, textFieldPesel.getText(), 
							textFieldPhone.getText(), textFieldEmail.getText(), textFieldCountry.getText(), textFieldCity.getText(), textFieldStreet.getText(), 
							Integer.parseInt(textFieldNumberOfBuilding.getText()), textFieldPostCode.getText(), textFieldLogin.getText(), textFieldPassword.getText());
					addNewPhysicalUser(userData);
				}
				else {
					Company companyData = new Company(textFieldFirmName.getText(), Double.parseDouble(textFieldNip.getText()),textFieldPhone.getText(), 
							textFieldEmail.getText(), textFieldCountry.getText(), textFieldCity.getText(), textFieldStreet.getText(), 
							Integer.parseInt(textFieldNumberOfBuilding.getText()), textFieldPostCode.getText(), textFieldLogin.getText(), textFieldPassword.getText() );
					addNewCompany(companyData);
				}
				
				//zamkniêcie bie¿¹cego okna i otwarcie poprzedniego
				RegisterWindow.this.dispose();
				if((parentFrame!=null)) {parentFrame.show();}
			}
		});
		
		
		
	}

	/*
	 * Metoda odpowiadaj¹ca za dodanie nowego u¿ytkownika do bazy danych
	 */
	public void addNewPhysicalUser(PhysicalUser userData) {
	    try {
			Connection connection = JavaDB.connectToDB();
	        Statement stat = connection.createStatement();
	        String SQL = "INSERT INTO User "
	                + "VALUES (NULL,"
	                + "'" + userData.getName() + "',"
	                + "'" + userData.getSurname() + "',"
	                + "'" + userData.getPhone() + "',"
	                + "'" + userData.getEmail() + "',"
	                + "'" + userData.getCountry() + "',"
	                + "'" + userData.getCity() + "',"
	                + "'" + userData.getStreet() + "',"
	                + "'" + userData.getNumberOfBuilding() + "',"
	                + "'" + userData.getPostCode() + "',"
	                + "'" + userData.getDateOfBirth() + "',"
	                + "'" + userData.getPesel() + "',"
	                + "'',"
	                + "'0',"
	                + "'" + userData.getLogin() + "',"
	                + "'" + userData.getPassword() + "'"
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
	    
    /*
	 * Metoda odpowiadaj¹ca za dodanie nowej firmy do bazy danych
	 */
    public void addNewCompany(Company companyData) {
    	 try {
    		 Connection connection = JavaDB.connectToDB();
    		 Statement stat = connection.createStatement();
    		 String SQL = "INSERT INTO User "
                + "VALUES (NULL,"
                + "'" + companyData.getName() + "',"
                + "'',"
                + "'" + companyData.getPhone() + "',"
                + "'" + companyData.getEmail() + "',"
                + "'" + companyData.getCountry() + "',"
                + "'" + companyData.getCity() + "',"
                + "'" + companyData.getStreet() + "',"
                + "'" + companyData.getNumberOfBuilding() + "',"
                + "'" + companyData.getPostCode() + "',"
                + "'',"
                + "'',"
                + "'" + companyData.getNip() + "',"
                + "'1',"
                + "'" + companyData.getLogin() + "',"
                + "'" + companyData.getPassword() + "'"
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

