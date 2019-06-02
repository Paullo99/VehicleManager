package Views;

import DB.JavaDB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JPasswordField;

public class LoginWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldLogin;
	private JPasswordField textFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow frame = new LoginWindow();
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
	public LoginWindow() {
		setTitle("VehicleManager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		/*
		 * otwiera okno rejestracji - RegisterWindow.java
		 */
		JButton btnRegister = new JButton("Zarejestruj si\u0119");
		btnRegister.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				RegisterWindow register = new RegisterWindow(LoginWindow.this);
				register.show();
				LoginWindow.this.hide();
			}
		});
		btnRegister.setBounds(170, 177, 101, 23);
		contentPane.add(btnRegister);
		/*
		 * Przycisk odpowiadaj¹cy za ³¹czenie z Baz¹ danych i sprawdzanie poprawnoœci danych logowania
		 */
		JButton btnLogin = new JButton("Zaloguj si\u0119");
		btnLogin.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				//sprawdzenie danych logowania
				boolean check = loginDatacheck(textFieldLogin.getText(), textFieldPassword.getText());
				if(check==true) {
					MainWindow mainWindow = new MainWindow();
					mainWindow.show();
				}
				else {
					JOptionPane.showMessageDialog(null, "Poda³eœ nieprawid³owy login lub has³o");
				}
			}
		});
		btnLogin.setBounds(317, 95, 90, 52);
		contentPane.add(btnLogin);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setText("admin");
		textFieldLogin.setBounds(118, 96, 187, 20);
		contentPane.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setText("pass");
		textFieldPassword.setToolTipText("has\u0142o");
		textFieldPassword.setBounds(118, 127, 187, 20);
		contentPane.add(textFieldPassword);
	}
	
	@SuppressWarnings("unused")
	private boolean loginDatacheck(String login, String password) {
		boolean isCorrect=false;
		//³¹czenie z DB
		JavaDB database = new JavaDB();
		Connection connection = JavaDB.connectToDB();
		Statement stat = null;
        try {
            stat = connection.createStatement(); 
            // Polecenie wyszukania
            String searchSQL = "SELECT * FROM User WHERE login == '"+login+"' AND password == '"+password+"';";
            ResultSet result = stat.executeQuery(searchSQL);
            if(result.getString("Id") != null) {
            	isCorrect = true;
            }
            result.close();
            stat.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Nie mogê wyszukaæ danych " + e.getMessage());
        }
		return isCorrect;
	}
}
