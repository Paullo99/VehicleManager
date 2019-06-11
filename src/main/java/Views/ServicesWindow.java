package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ServicesWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServicesWindow frame = new ServicesWindow(1);
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
	public ServicesWindow(int id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 705, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSerwisy = new JLabel("Serwisy");
		lblSerwisy.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblSerwisy.setHorizontalAlignment(SwingConstants.CENTER);
		lblSerwisy.setBounds(263, 11, 150, 58);
		contentPane.add(lblSerwisy);
		
		JButton btnAddService = new JButton("Dodaj us\u0142ug\u0119");
		btnAddService.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				AddNewServiceWindow.main(null);
			}
		});
		btnAddService.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddService.setBounds(10, 106, 172, 77);
		contentPane.add(btnAddService);
		
		JButton btnAddReview = new JButton("Dodaj Przegl\u0105d");
		btnAddReview.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddNewReviewWindow.main(null);
			}
		});
		btnAddReview.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddReview.setBounds(246, 106, 167, 77);
		contentPane.add(btnAddReview);
		
		JButton btnAddInsurance = new JButton("<html> <center> Dodaj <br> Ubezpieczenie </html>");
		btnAddInsurance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddNewInsuranceWindow.main(null);
			}
		});
		btnAddInsurance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAddInsurance.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddInsurance.setBounds(487, 106, 167, 77);
		contentPane.add(btnAddInsurance);
		
		JButton btnSaveServices = new JButton("Zamknij");
		btnSaveServices.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ServicesWindow.this.dispose();
			}
		});
		btnSaveServices.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSaveServices.setBounds(263, 341, 133, 77);
		contentPane.add(btnSaveServices);
		
		JButton btnHistoryOfServices = new JButton("<html> <center> Historia <br> us³ug </html>");
		btnHistoryOfServices.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ServiceHistoryWindow.main(null);
			}
		});
		btnHistoryOfServices.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHistoryOfServices.setBounds(10, 217, 172, 77);
		contentPane.add(btnHistoryOfServices);
		
		JButton btnHistoryOfReviews = new JButton("<html> <center> Historia <br> przegl¹dów </html>");
		btnHistoryOfReviews.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ReviewHistoryWindow.main(null);
			}
		});
		btnHistoryOfReviews.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHistoryOfReviews.setBounds(246, 217, 167, 77);
		contentPane.add(btnHistoryOfReviews);
		
		JButton btnHistoryOfInsurances = new JButton("<html> <center> Historia <br> Ubezpieczeñ </html>");
		btnHistoryOfInsurances.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				InsuranceHistoryWindow.main(null);
			}
		});
		btnHistoryOfInsurances.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHistoryOfInsurances.setBounds(487, 217, 167, 77);
		contentPane.add(btnHistoryOfInsurances);
	}
}
