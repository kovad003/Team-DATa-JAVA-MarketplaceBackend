package services;


import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.appengine.api.utils.SystemProperty;
import java.sql.Statement;

import conn.Connections;
import data.Customer;
/**
 * @author Dan
 *	This class contains all the service related to the customer table.
 */
@Path("/customerservice")

public class CustomerService {
//	*********************************************************************************************************
//	GET SERVICES ********************************************************************************************
//	*********************************************************************************************************
	/**
	 * @return ArrayList<Customer> list
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)//Method returns object as a JSON string
	@Path("/getall")
	public ArrayList<Customer> getAllCustomer() {
		String sql = "SELECT * FROM customer";
		ResultSet RS = null;
		ArrayList<Customer> list = new ArrayList<>();
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
		Statement stmt;
		try {
			stmt = conn.createStatement();
			RS=stmt.executeQuery(sql);
			while (RS.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(RS.getInt("customerId"));
				customer.setFirstName(RS.getString("firstName"));
				customer.setLastName(RS.getString("lastName"));
				customer.setUserName(RS.getString("userName"));
				customer.setPassword(RS.getString("password"));
				customer.setDateOfBirth(RS.getString("dateOfBirth"));
				customer.setEmail(RS.getString("email"));
				customer.setPhone(RS.getString("phone"));
				customer.setImage(RS.getString("image"));

				
				list.add(customer);
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
//				e.printStackTrace();
			}
		}
		return list;
	}
	
	/**
	 * @param id
	 * @return Customer customer
	 * This method receives a PathParam called id, which is used to fetch specific data from the database
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)//Method returns object as a JSON string
	@Path("/getcustomer/{customerId}")
	public Customer getCustomer(@PathParam("customerId") int customerId) {
		String sql = "SELECT * FROM customer WHERE customerId = ?;";
		Customer customer = new Customer();
		ResultSet RS = null;
		Connection conn=null;
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
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, customerId);
			RS = pstmt.executeQuery();
			while (RS.next()) {
				customer.setCustomerId(RS.getInt("customerId"));
				customer.setFirstName(RS.getString("firstName"));
				customer.setLastName(RS.getString("lastName"));
				customer.setUserName(RS.getString("userName"));
				customer.setPassword(RS.getString("password"));
				customer.setDateOfBirth(RS.getString("dateOfBirth"));
				customer.setEmail(RS.getString("email"));
				customer.setPhone(RS.getString("phone"));
				customer.setImage(RS.getString("image"));
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
//				e.printStackTrace();
			}
		}
		return customer;
	}
//		*********************************************************************************************************
//		POST SERVICES *******************************************************************************************
//		*********************************************************************************************************
		@POST
		@Produces(MediaType.APPLICATION_JSON) //Method returns object as a JSON string
		@Consumes("application/x-www-form-urlencoded") //Method can receive POSTed data from a html form
		@Path("/addcustomer")
		public Customer addCustomerByPost(
				@FormParam("customerId") int customerId, 
				@FormParam("firstName") String firstName, 
				@FormParam("lastName") String lastName,
				@FormParam("userName") String userName,
				@FormParam("password") String password,
				@FormParam("dateOfBirth") String dateOfBirth, 
				@FormParam("email") String email, 
				@FormParam("phone") String phone, 
				@FormParam("image") String image) {
			Customer customer=new Customer();
			customer.setCustomerId(customerId);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setUserName(userName);
			customer.setPassword(password);
			customer.setDateOfBirth(dateOfBirth);
			customer.setEmail(email);
			customer.setPhone(phone);
			customer.setImage(image);
			
			String sql="INSERT INTO customer (customerId, firstName , lastName, userName, password, dateOfBirth, email, phone, image)  VALUES(?,?, ?,?,?,?,?,?,?)";
			
			Connection conn=null;
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
			PreparedStatement pstmt;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, customerId);				
				pstmt.setString(2, firstName);
				pstmt.setString(3, lastName);
				pstmt.setString(4, userName);
				pstmt.setString(5, password);
				pstmt.setString(6, dateOfBirth);
				pstmt.setString(7, email);
				pstmt.setString(8, phone);
				pstmt.setString(9, image);
				pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
				}
			}			
			return customer;
		}

		/**
		 * @param Customer customer
		 * @return customer
		 * This method receives values from an html form which sends a POST type request.
		 */
		@POST
		@Produces(MediaType.APPLICATION_JSON)//Method returns object as a JSON string
		@Consumes(MediaType.APPLICATION_JSON)//Method receives object as a JSON string
		@Path("/addjsoncustomer")
		public Customer receiveJsonCustomer(Customer customer) {
			System.out.println("public Customer receiveJsonCustomer(Customer customer) {");
			String sql="INSERT INTO customer ( firstName , lastName, userName, password, dateOfBirth, email, phone, image)  VALUES(?,?,?,?,?,?,?,?)";
			
			Connection conn=null;
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
			PreparedStatement pstmt;
			try {
				/* Prepared statements */
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, customer.getFirstName());
				pstmt.setString(2, customer.getLastName());
				pstmt.setString(3, customer.getUserName());
				pstmt.setString(4, customer.getPassword());
				pstmt.setString(5, customer.getDateOfBirth());
				pstmt.setString(6, customer.getEmail());
				pstmt.setString(7, customer.getPhone());
				pstmt.setString(8, customer.getImage());

				pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
				}
			}
			
			customer.setFirstName(customer.getFirstName());
			return customer;
		}
		
//		*********************************************************************************************************
//		PUT SERVICES ********************************************************************************************
//		*********************************************************************************************************
		@PUT
		@Consumes(MediaType.APPLICATION_JSON) //Method takes object as a JSON string
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/updatejsoncustomer")
		public Customer updateCustomer(Customer customer) {
			System.out.println("public Customer updateCustomer(Customer customer) {");
			System.out.println("customer => " + customer);
			
			String sql = "UPDATE customer SET "
					+ "firstName = ?, "
					+ "lastName = ?, "
					+ "userName = ?, "
					+ "password = ?, "
					+ "dateOfBirth = ?, "
					+ "email = ?, "
					+ "phone = ? "
					+ "image = ? "
					+ "WHERE customerId = ?;";
			
			System.out.println("sql => " + sql);
			/*
				#1 name = ? 
				#2 price = ?
				#3 description = ?
				#4 category = ? 
				#5 id = ?;
			*/
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
			PreparedStatement pstmt;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, customer.getFirstName());
				pstmt.setString(2, customer.getLastName());
				pstmt.setString(3, customer.getUserName());
				pstmt.setString(4, customer.getPassword());
				pstmt.setString(5, customer.getDateOfBirth());
				pstmt.setString(6, customer.getEmail());
				pstmt.setString(7, customer.getPhone());
				pstmt.setString(8, customer.getImage());
				pstmt.setInt(9, customer.getCustomerId());
				pstmt.executeUpdate();
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
			return customer;
		}
		
//		*********************************************************************************************************
//		DELETE SERVICES *****************************************************************************************
//		*********************************************************************************************************	
		/**
		 * @param id
		 * void
		 * This method deletes an customer from then database based on the id number, which is received as a PathParam
		 */
//		@GET
		@DELETE
		@Path("/deletecustomer/{customerId}")
//		@Produces(MediaType.APPLICATION_JSON)//Method returns object as a JSON string
//		@Consumes(MediaType.APPLICATION_JSON)//Method receives object as a JSON string
		public boolean deleteCustomer(@PathParam("customerId") int customerId) {
			System.out.println("public void deleteCustomer(@PathParam(\"customerId\") int customerId) {");
			boolean removed = false; //Will be returned at the end -> feedback
			String sql="DELETE FROM customer WHERE customerId=?";
			Connection conn=null;
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
			// Delete customer
			PreparedStatement pstmt;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, customerId);
				pstmt.execute();
				// Verifying Removal
				if (pstmt.getUpdateCount() == 1) { // Return the affected number of rows
					removed = true;
				}
				System.out.println("pstmt.getUpdateCount() = " + pstmt.getUpdateCount());
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
			return removed;
		}
		
		@DELETE
		@Path("/deletejsoncustomer")
		@Produces(MediaType.APPLICATION_JSON)//Method returns object as a JSON string
		@Consumes(MediaType.APPLICATION_JSON)//Method receives object as a JSON string
		public boolean deleteJsonCustomer(Customer customer) {
			System.out.println("public void deleteJsonCustomer(Customer customer) {");
			boolean removed = false; //Will be returned at the end -> feedback
			String sql="DELETE FROM customer WHERE customerId=?";			
			Connection conn=null;
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
			PreparedStatement pstmt;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, customer.getCustomerId());
				pstmt.execute();
				// Verifying Removal
				if (pstmt.getUpdateCount() == 1) { // Return the affected number of rows
					removed = true;
				}
				System.out.println("pstmt.getUpdateCount() = " + pstmt.getUpdateCount());
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
			return removed;
		}		
}