package Views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

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
		setTitle("Serwisy");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 919, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSerwisy = new JLabel("Serwisy");
		lblSerwisy.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblSerwisy.setHorizontalAlignment(SwingConstants.CENTER);
		lblSerwisy.setBounds(263, 11, 150, 58);
		contentPane.add(lblSerwisy);
		
		/**
		 * Przycisk otwieraj¹cy nowe okno - Dodaj Us³ugê
		 */
		JButton btnAddService = new JButton("Dodaj us\u0142ug\u0119");
		btnAddService.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				AddNewServiceWindow addNewServiceWindow = new AddNewServiceWindow(id);
				addNewServiceWindow.show();
			}
		});
		btnAddService.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddService.setBounds(10, 106, 172, 77);
		contentPane.add(btnAddService);
		
		/**
		 * Przycisk otwieraj¹cy nowe okno - Dodaj przegl¹d
		 */
		JButton btnAddReview = new JButton("Dodaj Przegl\u0105d");
		btnAddReview.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddNewReviewWindow addNewReviewWindow = new AddNewReviewWindow(id);
				addNewReviewWindow.show();
			}
		});
		btnAddReview.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddReview.setBounds(246, 106, 167, 77);
		contentPane.add(btnAddReview);
		
		/**
		 * Przycisk otwieraj¹cy nowe okno - Dodaj ubezpieczenie
		 */
		JButton btnAddInsurance = new JButton("<html> <center> Dodaj <br> Ubezpieczenie </html>");
		btnAddInsurance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddNewInsuranceWindow addNewInsuranceWindow = new AddNewInsuranceWindow(id);
				addNewInsuranceWindow.show();
			}
		});
		btnAddInsurance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAddInsurance.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddInsurance.setBounds(487, 106, 167, 77);
		contentPane.add(btnAddInsurance);
		
		/**
		 * Przycisk odpowiedzialny za zamkniêcie okna Serwisy
		 */
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
		
		/**
		 * Przycisk otwieraj¹cy nowe okno - Historia serwisów
		 */
		JButton btnHistoryOfServices = new JButton("<html> <center> Historia <br> us³ug </html>");
		btnHistoryOfServices.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ServiceHistoryWindow serviceHistoryWindow = new ServiceHistoryWindow(id);
				serviceHistoryWindow.show();
			}
		});
		btnHistoryOfServices.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHistoryOfServices.setBounds(10, 217, 172, 77);
		contentPane.add(btnHistoryOfServices);
		
		/**
		 * Przycisk otwieraj¹cy nowe okno - Historia przegl¹dów
		 */
		JButton btnHistoryOfReviews = new JButton("<html> <center> Historia <br> przegl¹dów </html>");
		btnHistoryOfReviews.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ReviewHistoryWindow reviewHistoryWindow = new ReviewHistoryWindow(id);
				reviewHistoryWindow.show();
			}
		});
		btnHistoryOfReviews.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHistoryOfReviews.setBounds(246, 217, 167, 77);
		contentPane.add(btnHistoryOfReviews);
		
		/**
		 * Przycisk otwieraj¹cy nowe okno - historia ubezpieczeñ
		 */
		JButton btnHistoryOfInsurances = new JButton("<html> <center> Historia <br> Ubezpieczeñ </html>");
		btnHistoryOfInsurances.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				InsuranceHistoryWindow insuranceHistoryWindow = new InsuranceHistoryWindow(id);
				insuranceHistoryWindow.show();
			}
		});
		btnHistoryOfInsurances.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHistoryOfInsurances.setBounds(487, 217, 167, 77);
		contentPane.add(btnHistoryOfInsurances);
		
		/**
		 * Przycisk otwieraj¹cy nowe okno - historia tankowañ
		 */
		JButton buttonRefuellingHistory = new JButton("<html> <center> Historia <br> tankowa\u0144 </html>");
		buttonRefuellingHistory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				RefuellingHistoryWindow refuellingHistoryWindow = new RefuellingHistoryWindow(id);
				refuellingHistoryWindow.show();
			}
		});
		buttonRefuellingHistory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonRefuellingHistory.setBounds(707, 151, 167, 77);
		contentPane.add(buttonRefuellingHistory);
	}
}
