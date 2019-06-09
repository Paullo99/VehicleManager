package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import com.toedter.calendar.JCalendar;

import Classes.Insurance;
import Classes.Review;
import DB.JavaDB;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Statement;

public class AddNewReviewWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNoticesToReview;
	private JTextField textFieldCourseDuringReview;
	private JTextField textFieldPriceOfReview;
	private JTextField textFieldVehicleId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewReviewWindow frame = new AddNewReviewWindow();
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
	public AddNewReviewWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 695, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCalendar calendarDateOfReview = new JCalendar();
		calendarDateOfReview.setBounds(283, 55, 152, 153);
		contentPane.add(calendarDateOfReview);
		
		JLabel lblWanyDo = new JLabel("Data wykonania przegl\u0105du:");
		lblWanyDo.setHorizontalAlignment(SwingConstants.CENTER);
		lblWanyDo.setBounds(283, 30, 152, 14);
		contentPane.add(lblWanyDo);
		
		JRadioButton rdbtnPassed = new JRadioButton("Przeszed\u0142");
		rdbtnPassed.setSelected(true);
		rdbtnPassed.setBounds(129, 26, 109, 23);
		contentPane.add(rdbtnPassed);
		
		JLabel lblWynik = new JLabel("Wynik:");
		lblWynik.setBounds(31, 34, 46, 14);
		contentPane.add(lblWynik);
		
		textFieldNoticesToReview = new JTextField();
		textFieldNoticesToReview.setBounds(122, 85, 86, 20);
		contentPane.add(textFieldNoticesToReview);
		textFieldNoticesToReview.setColumns(10);
		
		textFieldCourseDuringReview = new JTextField();
		textFieldCourseDuringReview.setColumns(10);
		textFieldCourseDuringReview.setBounds(122, 116, 86, 20);
		contentPane.add(textFieldCourseDuringReview);
		
		textFieldPriceOfReview = new JTextField();
		textFieldPriceOfReview.setColumns(10);
		textFieldPriceOfReview.setBounds(122, 147, 86, 20);
		contentPane.add(textFieldPriceOfReview);
		
		textFieldVehicleId = new JTextField();
		textFieldVehicleId.setBounds(122, 178, 86, 20);
		contentPane.add(textFieldVehicleId);
		textFieldVehicleId.setColumns(10);
		
		JLabel lblUwagi_1 = new JLabel("Uwagi:");
		lblUwagi_1.setBounds(31, 88, 46, 14);
		contentPane.add(lblUwagi_1);
		
		JLabel lblUwagi = new JLabel("Przebieg:");
		lblUwagi.setBounds(31, 119, 46, 14);
		contentPane.add(lblUwagi);
		
		JLabel lblCena = new JLabel("Koszt:");
		lblCena.setBounds(31, 150, 46, 14);
		contentPane.add(lblCena);
		
		JLabel lblVehicleid = new JLabel("VehicleId");
		lblVehicleid.setBounds(31, 181, 46, 14);
		contentPane.add(lblVehicleid);
		
		JLabel lblDataWyganiciaPrzegldu = new JLabel("Data wyga\u015Bni\u0119cia przegl\u0105du:");
		lblDataWyganiciaPrzegldu.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataWyganiciaPrzegldu.setBounds(462, 30, 152, 14);
		contentPane.add(lblDataWyganiciaPrzegldu);
		
		JCalendar calendarExpirationDateOfReview = new JCalendar();
		calendarExpirationDateOfReview.setBounds(462, 55, 152, 153);
		contentPane.add(calendarExpirationDateOfReview);
		
		JRadioButton radioButtonNotPassed = new JRadioButton("Nie przeszed\u0142");
		radioButtonNotPassed.setBounds(129, 55, 109, 18);
		contentPane.add(radioButtonNotPassed);
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnPassed);
		btnGroup.add(radioButtonNotPassed);
		
		JButton btnConfirmNewReview = new JButton("Zatwierdz");
		btnConfirmNewReview.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnConfirmNewReview.setBounds(283, 263, 143, 67);
		contentPane.add(btnConfirmNewReview);
		
		btnConfirmNewReview.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				/*
				 * Tworzenie nowego obiektu Przegl¹d
				 * */
				Review reviewData = new Review(rdbtnPassed.isSelected(), calendarExpirationDateOfReview.getDate(), 
						textFieldNoticesToReview.getText(), textFieldCourseDuringReview.getText(), textFieldPriceOfReview.getText(), 
						calendarDateOfReview.getDate(), Integer.parseInt(textFieldVehicleId.getText()));
				
						AddNewReview(reviewData);
			}
				private void AddNewReview(Review reviewData) {
					try {
						Connection connection = JavaDB.connectToDB();
				        Statement stat = connection.createStatement();
				        String SQL = "INSERT INTO Review "
				                + "VALUES (NULL,"
				                + "'" + reviewData.isPassed() + "',"
				                + "'" + reviewData.getExpirationDate() + "',"
				                + "'" + reviewData.getNotices() + "',"
				                + "'" + reviewData.getCourse() + "',"
				                + "'" + reviewData.getPrice() + "',"
				                + "'" + reviewData.getDateOfEvent() + "',"
				                + "'" + reviewData.getVehicleId() + "'"
				                + ");";
				        System.out.println(SQL);
				        stat.executeUpdate(SQL);
				        stat.close();
				        connection.close();
				        /*
				         *  Komunikat i wydrukowanie koñcowej formy polecenia SQL
				         */
				        System.out.println("Polecenie: \n" + SQL + "\n wykonane.");
				    } catch (Exception e) {
				        System.out.println("Nie mogê dodaæ danych " + e.getMessage());
				    }
					dispose();
				}
			});
			
	
	}
}
