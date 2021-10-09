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
				customer.setId(RS.getString("id"));
				customer.setName(RS.getString("name"));
				customer.setFamily(RS.getString("family"));
				customer.setDateOfBirth(RS.getString("dateofbirth"));
				customer.setEmail(RS.getString("email"));
				customer.setPhone(RS.getString("phone"));
				customer.setImageUrl(RS.getString("imageurl"));

				
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
	@Path("/getcustomer/{id}")
	public Customer getCustomer(@PathParam("id") int id) {
		String sql = "SELECT * FROM customer WHERE id = ?;";
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
			pstmt.setInt(1, id);
			RS = pstmt.executeQuery();
			while (RS.next()) {
				customer.setId(RS.getString("id"));
				customer.setName(RS.getString("name"));
				customer.setFamily(RS.getString("family"));
				customer.setDateOfBirth(RS.getString("dateofbirth"));
				customer.setEmail(RS.getString("email"));
				customer.setPhone(RS.getString("phone"));
				customer.setImageUrl(RS.getString("imageurl"));
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
				@FormParam("id") String id, 
				@FormParam("name") String name, 
				@FormParam("family") String family,
				@FormParam("dateofbirth") String dateOfBirth, 
				@FormParam("email") String email, 
				@FormParam("phone") String phone, 
				@FormParam("imageurl") String imageUrl) {
			Customer customer=new Customer();
			customer.setId(id);
			customer.setName(name);
			customer.setFamily(family);
			customer.setDateOfBirth(dateOfBirth);
			customer.setEmail(email);
			customer.setPhone(phone);
			customer.setImageUrl(imageUrl);
			
			String sql="INSERT INTO customer (id, name , family, dateofbirth, email, phone, imageurl)  VALUES(?,?,?,?,?,?,?)";
			
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
				pstmt.setString(1, id);				
				pstmt.setString(2, name);
				pstmt.setString(3, family);
				pstmt.setString(4, dateOfBirth);
				pstmt.setString(5, email);
				pstmt.setString(6, phone);
				pstmt.setString(7, imageUrl);
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
			String sql="INSERT INTO customer (name, price, description, category) VALUES(?,?,?,?)";
			
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
				pstmt.setString(1, customer.getName());
				pstmt.setFloat(2,  customer.getPrice());
				pstmt.setString(3, customer.getDescription());
				pstmt.setString(4, customer.getCategory());
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
			
			customer.setName(customer.getName());
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
					+ "name = ?, "
					+ "price = ?, "
					+ "description = ?, "
					+ "category = ? "
					+ "WHERE id = ?;";
			
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
				pstmt.setString(1, customer.getName());
				pstmt.setFloat(2, customer.getPrice());
				pstmt.setString(3, customer.getDescription());
				pstmt.setString(4, customer.getCategory());
				pstmt.setInt(5, customer.getId());
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
		@Path("/deletecustomer/{id}")
//		@Produces(MediaType.APPLICATION_JSON)//Method returns object as a JSON string
//		@Consumes(MediaType.APPLICATION_JSON)//Method receives object as a JSON string
		public boolean deleteCustomer(@PathParam("id") int id) {
			System.out.println("public void deleteCustomer(@PathParam(\"id\") int id) {");
			boolean removed = false; //Will be returned at the end -> feedback
			String sql="DELETE FROM customer WHERE id=?";
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
				pstmt.setInt(1, id);
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
			String sql="DELETE FROM customer WHERE id=?";			
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
				pstmt.setInt(1, customer.getId());
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