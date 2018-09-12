package mainPackage;
import java.sql.*;

import javax.swing.JOptionPane;
public class DBConn {
	
	Connection con;
	Statement st;
	ResultSet rs;
	
	DBConn(){
		try {
			this.con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl", "system", "Oracle_1");
			this.st = con.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error retrieving data!");
		}
	}
	
	ResultSet RunQuery(String query) {
		try {
			this.rs = this.st.executeQuery(query);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return this.rs;
	}
	
	public static void main(String arg[]) {
		
	}
}
