package Views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainWindow extends JFrame {

	private JPanel contentPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1162, 660);
		setLocationRelativeTo(null);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JButton btnVehicles = new JButton("Pojazdy");
		btnVehicles.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVehicles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnVehicles.setBounds(0, 0, 125, 125);
		contentPanel.add(btnVehicles);
		
		JButton btnAddVehicle = new JButton("<html> Dodaj <br> pojazd </html>");
		btnAddVehicle.setToolTipText("");
		btnAddVehicle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddVehicle.setBounds(0, 124, 125, 125);
		contentPanel.add(btnAddVehicle);
		
		JButton btnStatistics = new JButton("Statystyki");
		btnStatistics.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStatistics.setBounds(0, 248, 125, 125);
		contentPanel.add(btnStatistics);
		
		JButton btnHelp = new JButton("<html> Pomoc <br> (info)  </html>");
		btnHelp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,"<html> Wersja programu: 1.0.0 <br>"
							+ "Data powstania: __.06.2019 r. <br><br>"
							+ "Autorzy: <br>"
							+ "Kewin Warzecha <br>"
							+ "Artur So³tys <br>"
							+ "Pawe³ Macioñczyk <br>"
							+ " </html>");
			}
		});
		btnHelp.setBounds(0, 373, 125, 125);
		contentPanel.add(btnHelp);
		
		JButton btnLogOut = new JButton("Wyloguj");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogOut.setBounds(0, 498, 125, 125);
		contentPanel.add(btnLogOut);
	}
}
