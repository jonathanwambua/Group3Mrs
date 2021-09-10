package MainFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MaternityWard  extends mysqlconnection{
	
	static int wid =  5;
	static int exec;
	
	public MaternityWard() throws SQLException {
		Connection con  =DriverManager.getConnection("jdbc:mysql://localhost:3306/ipd","root","kaptainamoh");	
	}
	
	
	public  interface container{
		public int capacity();
	}
	
	
	public static int capacity() throws SQLException {
		Connection con  =DriverManager.getConnection("jdbc:mysql://localhost:3306/ipd","root","kaptainamoh");
		int capacity = 0;

		PreparedStatement stmt;
		stmt = con.prepareStatement("select capacity from ward where wid = 1");
		ResultSet Rs =stmt.executeQuery();
		
		while(Rs.next()) {
			capacity = Rs.getInt("capacity");
		}
		 
		
		return capacity;
		
	}
	
	public static int currentpatients() throws SQLException {
		
		int currentpatients = 0;
		
		Connection con  =DriverManager.getConnection("jdbc:mysql://localhost:3306/ipd","root","kaptainamoh");
		int capacity = 0;

		PreparedStatement stmt;
		stmt = con.prepareStatement("select assignedbeds  from ward where wid = 1  ");
		ResultSet Rs = stmt.executeQuery();
		
		while(Rs.next()) {
			currentpatients = Rs.getInt("assignedbeds");
		}
		return currentpatients;
		
		
		
		
		
	}
	public static int availablebeds() throws SQLException {
		int availablebeds = 0;
		
		Connection con  =DriverManager.getConnection("jdbc:mysql://localhost:3306/ipd","root","kaptainamoh");

		PreparedStatement stmt;
		stmt = con.prepareStatement("select availablebeds  from ward where wid = 1  ");
		ResultSet Rs = stmt.executeQuery();
		
		while(Rs.next()) {
			availablebeds = Rs.getInt("availablebeds");
		}
		
		return availablebeds;
		
	}
	public static int assignedbeds() throws SQLException {
		int assignedbeds = 0;
		
		Connection con  =DriverManager.getConnection("jdbc:mysql://localhost:3306/ipd","root","kaptainamoh");
		
		PreparedStatement stmt;
		stmt = con.prepareStatement("select assignedbeds  from ward where wid = 1  ");
		ResultSet Rs = stmt.executeQuery();
		
		while(Rs.next()) {
			assignedbeds = Rs.getInt("assignedbeds");
		}
		
		
		return assignedbeds;
		
	}
	
	public static int percentageoccupancy() throws SQLException {
		int percentageoccupancy = 0;
		
		int assignedbeds = MaternityWard.assignedbeds();
		int capacity = MaternityWard.capacity();
		percentageoccupancy = ((assignedbeds * 100/capacity));
		
		return percentageoccupancy;
		
	}
	
	public static  void updtptnts() throws SQLException {
		int ptnts;
		
		int exec;
		
		Connection con  =DriverManager.getConnection("jdbc:mysql://localhost:3306/ipd","root","kaptainamoh");
		
		PreparedStatement stmt;
		stmt = con.prepareStatement("select assignedbeds  from ward where wid = 1  ");
		ResultSet Rs = stmt.executeQuery();
		
		while(Rs.next()) {
			ptnts = Rs.getInt("assignedbeds");
			ptnts =  ptnts-1 ;
			
			stmt= con.prepareStatement("update ward set assignedbeds =  ? where wid = 1");
			stmt.setInt(1, ptnts);
			exec = stmt.executeUpdate();
		}
		
		
		
	}
	public static void updtbeds() throws SQLException {
		int availablebeds;
		
		Connection con  =DriverManager.getConnection("jdbc:mysql://localhost:3306/ipd","root","kaptainamoh");
		
		
		PreparedStatement stmt;
		stmt = con.prepareStatement("select availablebeds  from ward where wid = 1  ");
		ResultSet Rs = stmt.executeQuery();
		
		while(Rs.next()) {
			availablebeds = Rs.getInt("availablebeds");
			availablebeds =  availablebeds  + 1 ;
			
			stmt= con.prepareStatement("update ward set availablebeds  =  ? where wid = 1");
			stmt.setInt(1, availablebeds);
			exec = stmt.executeUpdate();
		}
	}
	
	public static  void assignptnts() throws SQLException {
		int ptnts;
		
		int exec;
		
		Connection con  =DriverManager.getConnection("jdbc:mysql://localhost:3306/ipd","root","kaptainamoh");
		
		PreparedStatement stmt;
		stmt = con.prepareStatement("select assignedbeds  from ward where wid = 1  ");
		ResultSet Rs = stmt.executeQuery();
		
		while(Rs.next()) {
			ptnts = Rs.getInt("assignedbeds");
			
			
			if(ptnts > MaternityWard.capacity()) {
				errorbox.error();
			}
			else {
			ptnts =  ptnts+1 ;
			
			stmt= con.prepareStatement("update ward set assignedbeds =  ? where wid = 1");
			stmt.setInt(1, ptnts);
			exec = stmt.executeUpdate();	
			}
			
			}
		}
	
	public static void assignbed() throws SQLException {
		int availablebeds;
		
		Connection con  =DriverManager.getConnection("jdbc:mysql://localhost:3306/ipd","root","kaptainamoh");
		
		
		PreparedStatement stmt;
		stmt = con.prepareStatement("select availablebeds  from ward where wid = 1  ");
		ResultSet Rs = stmt.executeQuery();
		
		while(Rs.next()) {
			availablebeds = Rs.getInt("availablebeds");
			if( MaternityWard.assignedbeds() > MaternityWard.capacity()) {
				
				errorbox.error();
			}else {
				availablebeds =  availablebeds  - 1 ;
			
				stmt= con.prepareStatement("update ward set availablebeds  =  ? where wid = 1");
				stmt.setInt(1, availablebeds);
				exec = stmt.executeUpdate();
			}
			
			
		}
	}
	
	public static void main(String[] args) throws SQLException {
		
	}
	
}

