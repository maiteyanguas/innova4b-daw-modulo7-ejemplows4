package innova4b.ejemplows4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private Connection connection;
    
    public DBUtil(String url, String user, String pwd) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        this.connection = DriverManager.getConnection(url, user, pwd);
    }
     
    public Connection getConnection(){
        return this.connection;
    }
	
}
