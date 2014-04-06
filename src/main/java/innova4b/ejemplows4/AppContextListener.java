package innova4b.ejemplows4;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
    	ServletContext ctx = servletContextEvent.getServletContext();
        
        //initialize DB Connection
        String dbURL = ctx.getInitParameter("dbURL");
        String user = ctx.getInitParameter("dbUser");
        String pwd = ctx.getInitParameter("dbPassword");
         
        try {
            DBUtil connectionManager = new DBUtil(dbURL, user, pwd);
            ctx.setAttribute("DBConnection", connectionManager.getConnection());
            System.out.println("DB Connection initialized successfully.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
