package MainFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.Font;

public class patientreport extends JFrame{

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patientreport frame = new patientreport();
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
	public patientreport() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Generate ");
		btnNewButton.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Connection con  =DriverManager.getConnection("jdbc:mysql://localhost:3306/ipd","root","kaptainamoh");
					
					Statement st = con.createStatement();
					String sql = "select * from patient";
					ResultSet Rs = st.executeQuery(sql);
					
					
					while(Rs.next()) {
						
						
					String pid = String.valueOf(Rs.getInt("pid"));
					String name = String.valueOf(Rs.getString("name"));
					String age = String.valueOf(Rs.getString("age"));
					String admissiondate = String.valueOf(Rs.getString("admissiondate"));
					String wardname = String.valueOf(Rs.getString("wardname"));
					String bedno = String.valueOf(Rs.getString("bedno"));
					String dischargeddate = String.valueOf(Rs.getString("dischargedate"));
					String days = String.valueOf(Rs.getString("days"));
					
					
					String tabledata[] = { pid, name, age, admissiondate, wardname, bedno, dischargeddate, days };
					
					DefaultTableModel  tblmodel = (DefaultTableModel)table.getModel();
					
					tblmodel.addRow(tabledata);
					
					}
					
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		});
		btnNewButton.setBounds(0, 11, 122, 48);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"pid", "name", "age", "admissiondate", "wardname", "bedno", "dischargeddate", "days"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(63);
		table.getColumnModel().getColumn(2).setPreferredWidth(42);
		table.getColumnModel().getColumn(3).setPreferredWidth(125);
		table.getColumnModel().getColumn(4).setPreferredWidth(94);
		table.getColumnModel().getColumn(5).setPreferredWidth(43);
		table.getColumnModel().getColumn(6).setPreferredWidth(124);
		table.getColumnModel().getColumn(7).setPreferredWidth(58);
		table.setBounds(132, 11, 488, 239);
		contentPane.add(table);
	}
}
