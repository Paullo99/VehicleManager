package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import com.toedter.calendar.JCalendar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(122, 55, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JLabel lblWynik = new JLabel("Wynik:");
		lblWynik.setBounds(31, 55, 46, 14);
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
		
		JButton btnConfirmNewReview = new JButton("Zatwierdz");
		btnConfirmNewReview.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnConfirmNewReview.setBounds(283, 263, 143, 67);
		contentPane.add(btnConfirmNewReview);
	}
}
