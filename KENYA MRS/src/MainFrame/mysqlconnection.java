package MainFrame;

import java.sql.*;

public class mysqlconnection {
	public static void sqlconnection(int action) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con  =DriverManager.getConnection("jdbc:mysql://localhost:3306/bankaccount","root","kaptainamoh");
			con.close();
			
		} catch (Exception e){
			System.out.println(e);
		}

	}

}
