package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.appengine.api.utils.SystemProperty;

import java.sql.Statement;

import conn.Connections;
import data.Login;

/**
 * @author Dan
 *	Data class for "customer" table with the purpose of user authentication
 */
@Path("/loginservice")
public class LoginService {
//	*********************************************************************************************************
//	POST SERVICES ********************************************************************************************
//	*********************************************************************************************************
	/**
	 * @return 
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/validatelogindetails")
	public Login validateLoginDetails(Login input) {
		// Debugging messages
		System.out.println("public Login checkLoginDetails(Login login) {");
		System.out.println("Login input object: " + input.getUserName() + " & " + input.getPassword());

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
        String sql = "SELECT customerId, userName FROM customer WHERE userName = ? AND `password` = ?;"; // Define a MySQL query

        PreparedStatement pstmt; // Will deliver query to DB
		ResultSet RS = null; // Will deliver data back to JAVA from DB
		Login login = new Login(); // Constructor for Login object => Will be amended with the data from DB			
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, input.getUserName());
			pstmt.setString(2, input.getPassword());
			RS = pstmt.executeQuery();			
			while (RS.next()) {
				login.setCustomerId(RS.getInt("customerId"));
				login.setUserName(RS.getString("userName")); // ASH: it is necessary to amend script file with 'password' at `password column`
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
		System.out.println("customerId: " + login.getCustomerId());
		System.out.println("userName: " + login.getUserName());
		return login;
	}
//	*********************************************************************************************************
//	GET SERVICES ********************************************************************************************
//	*********************************************************************************************************
	/**
	 * @return list of ArrayList<Location> type containing region data only
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getlogindetails/{userName}")
	public Login getLoginDetails(@PathParam("userName") String userName) {
		System.out.println("userName = " + userName);
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
        String sql = "SELECT customerId, userName, `password` FROM customer WHERE userName = ?;"; // Define a MySQL query

        PreparedStatement pstmt; // Will deliver query to DB
		ResultSet RS = null; // Will deliver data back to JAVA from DB
		Login login = new Login(); // Constructor for Login object => Will be amended with the data from DB
				
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			RS = pstmt.executeQuery();			
			while (RS.next()) {
				login.setCustomerId(RS.getInt("customerId"));
				login.setUserName(RS.getString("userName")); // ASH: it is necessary to amend script file with 'password' at `password column`

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
		System.out.println("customerId: " + login.getCustomerId());
		System.out.println("userName: " + login.getUserName());
		System.out.println("password: " + login.getPassword());
		return login;
	}
}
