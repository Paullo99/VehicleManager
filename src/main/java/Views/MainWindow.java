package Views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;


public class MainWindow extends JFrame {

	private JPanel contentPanel;
	private JTable table;
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
		
		JButton btnVehicles = new JButton("Pojazdy");
		btnVehicles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//metoda ktora pokazuje tabele
			}
		});
		btnVehicles.setFont(new Font("Tahoma", Font.PLAIN, 20));

		
		btnVehicles.setBounds(0, 0, 125, 125);
		contentPanel.add(btnVehicles);

		btnVehicles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		
		JButton btnAddVehicle = new JButton("<html> Dodaj <br> pojazd </html>");
		btnAddVehicle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddVehicleWindow addVehicleWindow = new AddVehicleWindow();
				addVehicleWindow.show();
			}
		});
		btnAddVehicle.setToolTipText("");
		btnAddVehicle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnStatistics = new JButton("Statystyki");
		btnStatistics.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
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
		
		JButton btnLogOut = new JButton("Wyloguj");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				dispose();
				LoginWindow.main(null);
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(btnVehicles, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnAddVehicle, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnStatistics, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnHelp, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
							.addGap(42)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 777, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
					.addGap(192))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnVehicles, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(124)
							.addComponent(btnAddVehicle, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(248)
							.addComponent(btnStatistics, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
					.addComponent(btnHelp, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(32)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		
		//Tabela na wyniki
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Typ pojazdu", "Marka pojazdu", "Model", "Numer rejestracyjny", "W\u0142a\u015Bciwo\u015Bci"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(86);
		table.getColumnModel().getColumn(3).setPreferredWidth(112);
		scrollPane.setViewportView(table);
		contentPanel.setLayout(gl_contentPanel);
	}
	
	public void addRowToTable() {
		table.
	}
}
