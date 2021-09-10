package MainFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import MainFrame.ChildWard.container;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.Color;

public class Screen implements container  {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen window = new Screen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 707, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(20, 92, 671, 298);
		frame.getContentPane().add(layeredPane);
		
		JPanel ward = new JPanel();
		ward.setBounds(10, 11, 352, 276);
		layeredPane.add(ward);
		ward.setLayout(null);
		
		JLabel lblWard = new JLabel(" Ward");
		lblWard.setBounds(0, 0, 179, 31);
		ward.add(lblWard);
		lblWard.setFont(new Font("Tahoma", Font.BOLD, 24));
	
		
		JLabel lblCapacity = new JLabel(" Bed Capacity:");
		lblCapacity.setFont(new Font("Calisto MT", Font.BOLD, 20));
		lblCapacity.setBounds(10, 51, 143, 26);
		ward.add(lblCapacity);
		
	
		JLabel lblNewLabel = new JLabel("Patients");
		lblNewLabel.setFont(new Font("Calisto MT", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 82, 147, 25);
		ward.add(lblNewLabel);
		
		JLabel lblAvailableBeds = new JLabel("Available Beds");
		lblAvailableBeds.setFont(new Font("Calisto MT", Font.BOLD, 20));
		lblAvailableBeds.setBounds(10, 118, 147, 25);
		ward.add(lblAvailableBeds);
		
		JLabel lbloccupancy = new JLabel("%Occupancy");
		lbloccupancy.setFont(new Font("Calisto MT", Font.BOLD, 20));
		lbloccupancy.setBounds(10, 147, 147, 25);
		ward.add(lbloccupancy);
		
		JLabel lblCpct = new JLabel("");
		lblCpct.setBounds(206, 58, 74, 20);
		ward.add(lblCpct);
		
		JLabel lblPtnts = new JLabel("");
		lblPtnts.setBounds(206, 88, 74, 16);
		ward.add(lblPtnts);
		
		JLabel lblBds = new JLabel("");
		lblBds.setBounds(206, 118, 74, 16);
		ward.add(lblBds);
		
		JLabel lblOcpcy = new JLabel("");
		lblOcpcy.setBounds(206, 147, 74, 16);
		ward.add(lblOcpcy);
		
		JButton btnNewButton_14 = new JButton("Admit");
		btnNewButton_14.setBackground(new Color(175, 238, 238));
		btnNewButton_14.setForeground(new Color(106, 90, 205));
		btnNewButton_14.setFont(new Font("Calisto MT", Font.BOLD, 15));
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					ChildWard.assignbed();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					ChildWard.assignptnts();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton_14.setBounds(230, 223, 112, 42);
		ward.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("Discharge");
		btnNewButton_15.setFont(new Font("Calisto MT", Font.BOLD, 15));
		btnNewButton_15.setForeground(new Color(72, 61, 139));
		btnNewButton_15.setBackground(new Color(175, 238, 238));
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					ChildWard.updtbeds();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					ChildWard.updtptnts();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_15.setBounds(10, 223, 100, 42);
		ward.add(btnNewButton_15);
		
		JButton btnNewButton = new JButton("Child Ward");
		btnNewButton.setForeground(new Color(34, 139, 34));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int cpct = 0;
				int ptnts = 0;
				int bds = 0;
				int ocpcy = 0;
				lblWard.setText("Child Ward");
				
				
				try {
				 cpct = ChildWard.capacity();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				lblCpct.setText(Integer.toString(cpct) + " " + " beds");
				
				
				try {
					ptnts = ChildWard.currentpatients();
				} catch (SQLException e) {
		
					e.printStackTrace();
				}
				
				lblPtnts.setText(Integer.toString(ptnts) +" " + "patients");
				
				
				
				try {
					bds = ChildWard.availablebeds();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				lblBds.setText(Integer.toString(bds) + " " + "beds");
				
				
				
				try {
					ocpcy = ChildWard.percentageoccupancy();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				lblOcpcy.setText(Integer.toString(ocpcy) + "%");
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(372, 11, 144, 23);
		layeredPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Male Medical Ward");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setForeground(new Color(34, 139, 34));
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_1.setBounds(372, 49, 144, 23);
		layeredPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Observation Ward");
		btnNewButton_2.setForeground(new Color(34, 139, 34));
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_2.setBounds(372, 89, 144, 23);
		layeredPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Recovery Ward");
		btnNewButton_3.setForeground(new Color(34, 139, 34));
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_3.setBounds(372, 129, 144, 23);
		layeredPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Suspect Ward");
		btnNewButton_4.setForeground(new Color(34, 139, 34));
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_4.setBounds(372, 169, 144, 23);
		layeredPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Psychiatric Ward");
		btnNewButton_5.setForeground(new Color(34, 139, 34));
		btnNewButton_5.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_5.setBounds(372, 208, 144, 23);
		layeredPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Isolation Ward");
		btnNewButton_6.setForeground(new Color(34, 139, 34));
		btnNewButton_6.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_6.setBounds(372, 252, 144, 23);
		layeredPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Mortuary");
		btnNewButton_7.setForeground(new Color(34, 139, 34));
		btnNewButton_7.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_7.setBounds(526, 252, 135, 23);
		layeredPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Ammenity");
		btnNewButton_8.setForeground(new Color(34, 139, 34));
		btnNewButton_8.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_8.setBounds(526, 208, 135, 23);
		layeredPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Intensive Care Unit");
		btnNewButton_9.setForeground(new Color(34, 139, 34));
		btnNewButton_9.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_9.setBounds(526, 169, 135, 23);
		layeredPane.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("Gynaecology Ward");
		btnNewButton_10.setForeground(new Color(34, 139, 34));
		btnNewButton_10.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_10.setBounds(526, 129, 135, 23);
		layeredPane.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("Eye Ward");
		btnNewButton_11.setForeground(new Color(34, 139, 34));
		btnNewButton_11.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_11.setBounds(526, 89, 135, 23);
		layeredPane.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("Paediatric Ward");
		btnNewButton_12.setForeground(new Color(34, 139, 34));
		btnNewButton_12.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_12.setBounds(526, 49, 135, 23);
		layeredPane.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("Maternity ");
		btnNewButton_13.setForeground(new Color(34, 139, 34));
		btnNewButton_13.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int cpct = 0;
				int ptnts = 0;
				int bds = 0;
				int ocpcy = 0;
				lblWard.setText("Maternity Ward");
				
				
				try {
				 cpct = MaternityWard.capacity();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				lblCpct.setText(Integer.toString(cpct) + " " + " beds");
				
				
				try {
					ptnts = MaternityWard.currentpatients();
				} catch (SQLException e1) {
		
					e1.printStackTrace();
				}
				
				lblPtnts.setText(Integer.toString(ptnts) +" " + "patients");
				
				
				
				try {
					bds = MaternityWard.availablebeds();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				lblBds.setText(Integer.toString(bds) + " " + "beds");
				
				
				
				try {
					ocpcy = MaternityWard.percentageoccupancy();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				lblOcpcy.setText(Integer.toString(ocpcy) + "%");
				
				
			}
		});
		btnNewButton_13.setBounds(526, 11, 135, 23);
		layeredPane.add(btnNewButton_13);
		
		JLabel lblIpdWards = new JLabel("INPATIENT WARDS");
		lblIpdWards.setForeground(new Color(165, 42, 42));
		lblIpdWards.setBounds(20, 11, 292, 48);
		lblIpdWards.setFont(new Font("Segoe UI", Font.BOLD, 30));
		frame.getContentPane().add(lblIpdWards);
		
		JButton btnNewButton_16 = new JButton("Report");
		btnNewButton_16.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_16.setForeground(new Color(245, 245, 220));
		btnNewButton_16.setBackground(new Color(0, 128, 128));
		btnNewButton_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				patientreport rep = new patientreport();
				rep.setVisible(true);
				
			}
		});
		
		btnNewButton_16.setBounds(572, 23, 109, 33);
		frame.getContentPane().add(btnNewButton_16);
	}

	@Override
	public int capacity() {
		// TODO Auto-generated method stub
		return 0;
	}
}
