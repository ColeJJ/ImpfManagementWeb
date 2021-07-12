package awk.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* 
 * Die Klasse fasst alle Methoden zusammen, die direkt mit der DB zu tun haben
 */

public class Persistence {
	
	public static Connection getConnection(){
		Connection aConnection = null;
		try {
			Class.forName ("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		try {
			aConnection = 
					DriverManager.getConnection (
							"jdbc:oracle:thin:@131.173.92.216:1521:orcl", "VS2021_16", "NewYork99");
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return(aConnection);	
	}
	
	public static void closeConnection(Connection aConnection){
		try {
			aConnection.close();
		} catch (SQLException e) {
				e.printStackTrace();
		}	
	}
	
	public static void executeUpdateStatement(Connection aConnection, String aStatement) throws SQLException{
		System.out.println(aStatement);
		Statement stmt = aConnection.createStatement();
		stmt.executeUpdate(aStatement);
		
	}
	
	public static ResultSet executeQueryStatement(Connection aConnection, String aStatement) throws SQLException{
		ResultSet aResultSet = null;
		System.out.println(aStatement);
		Statement stmt = aConnection.createStatement();
		aResultSet =  stmt.executeQuery(aStatement);
		
		return aResultSet;
	}
}
