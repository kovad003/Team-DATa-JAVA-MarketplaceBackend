package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.appengine.api.utils.SystemProperty;

import java.sql.Statement;

import conn.Connections;
import data.Login;

/**
 * @author Ash
 *	Data class for "customer" table with the purpose of user authentication
 */
@Path("/login2service")
public class Login2UserNameService {
//	*********************************************************************************************************
//	GET SERVICES ********************************************************************************************
//	*********************************************************************************************************
	/**
	 * @return list of ArrayList<Location> type containing region data only
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/checkusername/{userName}")
	public Login getLoginDetails(@PathParam("userName") String userName) {
        // Debugging Message
		System.out.println("public Login getLoginDetails() {");
        
        // Get Connection to DB
        Connection conn = null;
		try {
		    if (SystemProperty.environment.value() ==SystemProperty.Environment.Value.Production) {  
		    	conn = Connections.getProductionConnection();
		    }
		    else {
		    	conn = Connections.getDevConnection();
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Initialise Empty Objects for Data Transfer
        String sql = "SELECT userName, `password` FROM customer WHERE userName = ?;"; // Define a MySQL query
        PreparedStatement pstmt; // Will deliver query to DB
		ResultSet RS = null; // Will deliver data back to JAVA from DB
		Login login = new Login(); // Constructure for Login object => Will be amended with the data from DB
				
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			RS = pstmt.executeQuery();			
			while (RS.next()) {
				login.setUserName(RS.getString("userName"));
				login.setPassword(RS.getString("password")); // ASH: it is necessary to amend script file with 'password' at `password column`
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return login;
	}
}