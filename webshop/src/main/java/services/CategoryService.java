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
import data.Category;
/**
 * @author Dan
 *	This class contains all the service related to the item table.
 */
@Path("/categoryservice")

public class CategoryService {
//	*********************************************************************************************************
//	GET SERVICES ********************************************************************************************
//	*********************************************************************************************************
	/**
	 * @return ArrayList<Category> list
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)//Method returns object as a JSON string
	@Path("/getall")
	public ArrayList<Category> getAllCategory() {
		System.out.println("public ArrayList<Category> getAllCategory() {");
		String sql = "SELECT * FROM category";
		ResultSet RS = null;
		ArrayList<Category> list = new ArrayList<>();
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
				Category cat = new Category();
				cat.setId(RS.getString("id"));
				cat.setTitle(RS.getString("title"));
				cat.setColor(RS.getString("color"));
				cat.setDescription(RS.getString("description"));
				cat.setImageUrl(RS.getString("imageurl"));
				
				list.add(cat);
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
		System.out.println("category list: " + list);
		return list;
	}
	
	
	
	
	
	/**************************************************************************************************************
	/*************************************************************************************************************
	/ HH - For now just create the get all 
	/ HH - under this line is not ready to use yet
	 */
	/**
	 * @param id
	 * @return Category category
	 * This method receives a PathParam called id, which is used to fetch specific data from the database
	 */
	
	// HH - If you want to use Uncomment All lines from here to end***********************************************
	
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)//Method returns object as a JSON string
//	@Path("/getcategory/{id}")
//	public Category getCategory(@PathParam("id") int id) {
//		String sql = "SELECT * FROM category WHERE id = ?;";
//		Category cat = new Category();
//		ResultSet RS = null;
//		Connection conn=null;
//		try {
//		    if (SystemProperty.environment.value() ==SystemProperty.Environment.Value.Production) {  
//		    	conn = Connections.getProductionConnection();
//		    }
//		    else {
//		    	conn = Connections.getDevConnection();
//		    }
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		PreparedStatement pstmt;
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, id);
//			RS = pstmt.executeQuery();
//			while (RS.next()) {
//				cat.setId(RS.getInt("id"));
//				cat.setName(RS.getString("name"));
//				cat.setPrice(RS.getString("price"));
//				cat.setDescription(RS.getString("description"));
//				cat.setCategory(RS.getString("category"));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if (conn!=null) {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
////				e.printStackTrace();
//			}
//		}
//		return cat;
//	}
////		*********************************************************************************************************
////		POST SERVICES *******************************************************************************************
////		*********************************************************************************************************
//		@POST
//		@Produces(MediaType.APPLICATION_JSON) //Method returns object as a JSON string
//		@Consumes("application/x-www-form-urlencoded") //Method can receive POSTed data from a html form
//		@Path("/addcategory")
//		public Category addDogBreedByPost(
//				@FormParam("name") String name, 
//				@FormParam("price") float price, 
//				@FormParam("description") String description, 
//				@FormParam("category") String category) {
//			Category cat=new Category();
//			cat.setName(name);
//			cat.setPrice(price);
//			cat.setDescription(description);
//			cat.setCategory(category);
//			
//			String sql="INSERT INTO category (name, price, description, category) VALUES(?,?,?,?)";
//			
//			Connection conn=null;
//			try {
//			    if (SystemProperty.environment.value() ==SystemProperty.Environment.Value.Production) {  
//			    	conn = Connections.getProductionConnection();
//			    }
//			    else {
//			    	conn = Connections.getDevConnection();
//			    }
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			PreparedStatement pstmt;
//			try {
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, name);
//				pstmt.setFloat(2,  price);
//				pstmt.setString(3, description);
//				pstmt.setString(4, category);
//				pstmt.execute();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			if (conn!=null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
////					e.printStackTrace();
//				}
//			}			
//			return cat;
//		}
//
//		/**
//		 * @param Category category
//		 * @return cat
//		 * This method receives values from an html form which sends a POST type request.
//		 */
//		@POST
//		@Produces(MediaType.APPLICATION_JSON)//Method returns object as a JSON string
//		@Consumes(MediaType.APPLICATION_JSON)//Method receives object as a JSON string
//		@Path("/addjsoncategory")
//		public Category receiveJsonCategory(Category cat) {
//			System.out.println("public Category receiveJsonCategory(Category cat) {");
//			String sql="INSERT INTO category (name, price, description, category) VALUES(?,?,?,?)";
//			
//			Connection conn=null;
//			try {
//			    if (SystemProperty.environment.value() ==SystemProperty.Environment.Value.Production) {  
//			    	conn = Connections.getProductionConnection();
//			    }
//			    else {
//			    	conn = Connections.getDevConnection();
//			    }
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			PreparedStatement pstmt;
//			try {
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, cat.getName());
//				pstmt.setFloat(2,  cat.getPrice());
//				pstmt.setString(3, cat.getDescription());
//				pstmt.setString(4, cat.getCategory());
//				pstmt.execute();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			if (conn!=null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
////					e.printStackTrace();
//				}
//			}
//			
//			cat.setName(cat.getName());
//			return cat;
//		}
//		
////		*********************************************************************************************************
////		PUT SERVICES ********************************************************************************************
////		*********************************************************************************************************
//		@PUT
//		@Consumes(MediaType.APPLICATION_JSON) //Method takes object as a JSON string
//		@Produces(MediaType.APPLICATION_JSON)
//		@Path("/updatejsoncategory")
//		public Category updateCategory(Category cat) {
//			System.out.println("public Category updateCategory(Category cat) {");
//			System.out.println("cat => " + cat);
//			
//			String sql = "UPDATE category SET "
//					+ "name = ?, "
//					+ "price = ?, "
//					+ "description = ?, "
//					+ "category = ? "
//					+ "WHERE id = ?;";
//			
//			System.out.println("sql => " + sql);
//			/*
//				#1 name = ? 
//				#2 price = ?
//				#3 description = ?
//				#4 category = ? 
//				#5 id = ?;
//			*/
//			Connection conn = null;
//			try {
//			    if (SystemProperty.environment.value() ==SystemProperty.Environment.Value.Production) {  
//			    	conn = Connections.getProductionConnection();
//			    }
//			    else {
//			    	conn = Connections.getDevConnection();
//			    }
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			PreparedStatement pstmt;
//			try {
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, cat.getName());
//				pstmt.setFloat(2, cat.getPrice());
//				pstmt.setString(3, cat.getDescription());
//				pstmt.setString(4, cat.getCategory());
//				pstmt.setInt(5, cat.getId());
//				pstmt.executeUpdate();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			if (conn!=null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			return cat;
//		}
//		
////		*********************************************************************************************************
////		DELETE SERVICES *****************************************************************************************
////		*********************************************************************************************************	
//		/**
//		 * @param id
//		 * void
//		 * This method deletes an category from then database based on the id number, which is received as a PathParam
//		 */
////		@GET
//		@DELETE
//		@Path("/deletecategory/{id}")
////		@Produces(MediaType.APPLICATION_JSON)//Method returns object as a JSON string
////		@Consumes(MediaType.APPLICATION_JSON)//Method receives object as a JSON string
//		public boolean deleteCategory(@PathParam("id") int id) {
//			System.out.println("public void deleteCategory(@PathParam(\"id\") int id) {");
//			boolean removed = false; //Will be returned at the end -> feedback
//			String sql="DELETE FROM category WHERE id=?";
//			Connection conn=null;
//			try {
//			    if (SystemProperty.environment.value() ==SystemProperty.Environment.Value.Production) {  
//			    	conn = Connections.getProductionConnection();
//			    }
//			    else {
//			    	conn = Connections.getDevConnection();
//			    }
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			// Delete category
//			PreparedStatement pstmt;
//			try {
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setInt(1, id);
//				pstmt.execute();
//				// Verifying Removal
//				if (pstmt.getUpdateCount() == 1) { // Return the affected number of rows
//					removed = true;
//				}
//				System.out.println("pstmt.getUpdateCount() = " + pstmt.getUpdateCount());
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			if (conn!=null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			return removed;
//		}
//		
//		@DELETE
//		@Path("/deletejsoncategory")
//		@Produces(MediaType.APPLICATION_JSON)//Method returns object as a JSON string
//		@Consumes(MediaType.APPLICATION_JSON)//Method receives object as a JSON string
//		public boolean deleteJsonCategory(Category cat) {
//			System.out.println("public void deleteJsonCategory(Category cat) {");
//			boolean removed = false; //Will be returned at the end -> feedback
//			String sql="DELETE FROM category WHERE id=?";			
//			Connection conn=null;
//			try {
//			    if (SystemProperty.environment.value() ==SystemProperty.Environment.Value.Production) {  
//			    	conn = Connections.getProductionConnection();
//			    }
//			    else {
//			    	conn = Connections.getDevConnection();
//			    }
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			PreparedStatement pstmt;
//			try {
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setInt(1, cat.getId());
//				pstmt.execute();
//				// Verifying Removal
//				if (pstmt.getUpdateCount() == 1) { // Return the affected number of rows
//					removed = true;
//				}
//				System.out.println("pstmt.getUpdateCount() = " + pstmt.getUpdateCount());
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			if (conn!=null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			return removed;
//		}		
}