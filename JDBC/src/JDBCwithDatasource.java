
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class JDBCwithDatasource {
	
	public static DataSource getdata()
	{
		MysqlDataSource datasource = new MysqlDataSource();
		
		datasource.setServerName("localhost");
		datasource.setPortNumber(3306);
		datasource.setDatabaseName("practice_1");
		datasource.setUser("root");
		datasource.setPassword("mysql");
		return datasource;	
	}
	
	
	public static void main(String args[])
	{
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet res =null;
		
		try {
			
			conn = getdata().getConnection();
	stmt = conn.createStatement();
	res = stmt.executeQuery("SELECT * FROM city");
		while(res.next())
		{
			//Retrieve by column name
		    int id  = res.getInt("id");
		    String Name = res.getString("Name");
		    String address = res.getString("address");
		    int phone = res.getInt("phone");

		    //Display values
		    System.out.print("ID: " + id);
		    System.out.print(", Name: " + Name);
		    System.out.print(", address: " + address);
		    System.out.println(", phone: " + phone);
		    
		}
		res.close();
	    stmt.close();
	    conn.close();
		}
		
		catch (SQLException e) {
		      e.printStackTrace();
		    } finally {
		      try {
		        if (res != null) {
		          res.close();
		        }
		        if (stmt != null) {
		          stmt.close();
		        }
		        if (conn != null) {
		          conn.close();
		        }
		      } catch (Exception e) {
		        e.printStackTrace();
		      }
		
		
		
	}
	
	
	

	}}
