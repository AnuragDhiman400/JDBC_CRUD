import java.sql.Statement;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCExample {
static final String JDBC_Driver ="com.mysql.cj.jdbc.Driver";
static final String DB_URL = "jdbc:mysql://localhost/practice_1";

static final String USER = "root";
static final String PASS = "mysql";


public static void main(String args[])
{
	
Connection conn=null;
Statement stmt=null;

try
{
	Class.forName("com.mysql.cj.jdbc.Driver");

System.out.println("Connecting to Database....");
conn = DriverManager.getConnection(DB_URL,USER,PASS);

System.out.print("Creating Statement....");
stmt=conn.createStatement();
String sql;
sql="SELECT * FROM city";
ResultSet rs = stmt.executeQuery(sql);
	
while(rs.next()){
    //Retrieve by column name
    int id  = rs.getInt("id");
    String Name = rs.getString("Name");
    String address = rs.getString("address");
    int phone = rs.getInt("phone");

    //Display values
    System.out.print("ID: " + id);
    System.out.print(", Name: " + Name);
    System.out.print(", address: " + address);
    System.out.println(", phone: " + phone);
   
 }
	
rs.close();
stmt.close();
conn.close();
}
catch(Exception e)
{
System.out.println(e.getMessage());	
}
finally{
    //finally block used to close resources
    try{
       if(stmt!=null)
          stmt.close();
    }catch(SQLException se2){
    }// nothing we can do
    try{
       if(conn!=null)
          conn.close();
    }catch(SQLException se){
       se.printStackTrace();
    }//end finally try
 }//end try
 System.out.println("Goodbye!");
}//end main



}










