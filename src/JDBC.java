
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;


public class JDBC {
public static void main(String[] args) throws SQLException

{
	//step=1 Load the driver
	Driver my_sql=new Driver();
	DriverManager.registerDriver(my_sql);
	
	//step=2 get the connection
	Connection con=DriverManager.getConnection("jdbc:mysql://192.168.0.109:3306/"+"studentsapp_db","j2ee","j2ee");
	
	//step=3 create a statement 
	java.sql.Statement stat=con.createStatement();
	
	//step=4 Execute quarry
	ResultSet rs=stat.executeQuery("select * from employee");
	while(rs.next())
	{
		System.out.println(rs.getString(3));
	}
	
	//step=5 close the connection
	con.close();
}
}
