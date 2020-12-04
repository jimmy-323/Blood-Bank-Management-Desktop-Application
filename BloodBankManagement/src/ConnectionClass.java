import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ConnectionClass {
	public static Connection dbConnection()
	{
		Connection conn=null;
		
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bbm","root", "");
			
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		return conn;
		
	}

	public static void main(String[] args)
	{
		Connection a=dbConnection();
		if(a==null)
		{
			JOptionPane.showMessageDialog(null,"Database Connection Error");
		}
		
	}
}

