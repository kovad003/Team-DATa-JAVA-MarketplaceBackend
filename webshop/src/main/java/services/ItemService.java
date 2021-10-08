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
import data.Item;
/**
 * @author Dan
 *	This class contains all the service related to the item table.
 */
@Path("/itemservice")

public class ItemService {
//	*********************************************************************************************************
//	GET SERVICES ********************************************************************************************
//	*********************************************************************************************************
	/**
	 * @return list of ArrayList<Item> type
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getall")
	public ArrayList<Item> getAllItem() {
		String sql = "SELECT * FROM item";
		ResultSet RS = null;
		ArrayList<Item> list = new ArrayList<>();
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
				Item item = new Item();
				item.setItemId(RS.getInt("itemId"));
				item.setItemId(RS.getInt("categoryId"));
				item.setItemId(RS.getInt("customerId"));
				item.setTitle(RS.getString("title"));
				item.setPrice(RS.getString("price"));
				item.setDescription(RS.getString("description"));
				item.setCondition(RS.getString("condition"));
				list.add(item);
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
	 * @return Item item
	 * This method receives a PathParam called id, which is used to fetch specific data from the database
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)//Method returns object as a JSON string
	@Path("/getitem/{id}")
	public Item getItem(@PathParam("id") int id) {
		String sql = "SELECT * FROM item WHERE itemId = ?;";
		Item item = new Item();
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
				item.setItemId(RS.getInt("id"));
				item.setTitle(RS.getString("name"));
				item.setPrice(RS.getString("price"));
				item.setDescription(RS.getString("description"));
				item.setCondition(RS.getString("category"));
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
		return item;
	}
//		*********************************************************************************************************
//		POST SERVICES *******************************************************************************************
//		*********************************************************************************************************
		@POST
		@Produces(MediaType.APPLICATION_JSON) //Method returns object as a JSON string
		@Consumes("application/x-www-form-urlencoded") //Method can receive POSTed data from a html form
		@Path("/additem")
		public Item addFormItem(
				@FormParam("categoryid") int categoryid,
				@FormParam("customerid") int customerid,
				@FormParam("title") String title, 
				@FormParam("price") float price,
				@FormParam("image") String image,
				@FormParam("description") String description,
				@FormParam("condition") String condition){
			System.out.println("public Item addFormItem(");
			Item item=new Item();
			item.setCategoryId(categoryid);
			item.setCustomerId(customerid);
			item.setTitle(title);
			item.setPrice(price);
			item.setDescription(description);
			item.setImage(image);
			item.setCondition(condition);
						
			String sql="INSERT INTO item (categoryId, customerId, title, price, description, image, `condition`) VALUES(?,?,?,?,?,?,?)";
			
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
				pstmt.setInt(1, item.getCategoryId());
				pstmt.setInt(2, item.getCustomerId());
				pstmt.setString(3, item.getTitle());
				pstmt.setFloat(4,  item.getPrice());
				pstmt.setString(5, item.getDescription());
				pstmt.setString(6, item.getImage());
				pstmt.setString(7, item.getCondition());
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
			return item;
		}

		/**
		 * @param Item item
		 * @return item
		 * This method receives values from an html form which sends a POST type request.
		 */
		@POST
		@Produces(MediaType.APPLICATION_JSON)//Method returns object as a JSON string
		@Consumes(MediaType.APPLICATION_JSON)//Method receives object as a JSON string
		@Path("/addjsonitem")
		public Item addJsonItem(Item item) {
			System.out.println("public Item addJsonItem(Item item) {");
			String sql="INSERT INTO item (categoryId, customerId, title, price, description, image, `condition`) VALUES(?,?,?,?,?,?,?)";
			Connection conn=null;
			try {
			    if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {  
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
				pstmt.setInt(1, item.getCategoryId());
				pstmt.setInt(2, item.getCustomerId());
				pstmt.setString(3, item.getTitle());
				pstmt.setFloat(4,  item.getPrice());
				pstmt.setString(5, item.getDescription());
				pstmt.setString(6, item.getImage());
				pstmt.setString(7, item.getCondition());
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
			
			item.setTitle(item.getTitle());
			return item;
		}
		
//		*********************************************************************************************************
//		PUT SERVICES ********************************************************************************************
//		*********************************************************************************************************
		@PUT
		@Consumes(MediaType.APPLICATION_JSON) //Method takes object as a JSON string
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/updatejsonitem")
		public Item updateJsonItem(Item item) {
			System.out.println("public Item updateItem(Item item) {");
			System.out.println("item => " + item);
			
			String sql = "UPDATE item SET "
					/* 1 */ + "categoryId = ?, "
					/* 2 */ + "customerId = ?, "
					/* 3 */ + "title = ?, "
					/* 4 */ + "price = ? "
					/* 5 */ + "description = ? "
					/* 6 */ + "image = ? "
					/* 7 */ + "`condition` = ? "
					/* 8 */ + "WHERE itemId = ?;";
			System.out.println("item.getImage() = " + item.getImage());
			// itemId, categoryId, customerId, title, price, description, image, condition, datePosted
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
				pstmt.setInt(1, item.getCategoryId());
				pstmt.setInt(2, item.getCustomerId());
				pstmt.setString(3, item.getTitle());
				pstmt.setFloat(4, item.getPrice());
				pstmt.setString(5, item.getDescription());
				pstmt.setString(6, item.getImage());
				pstmt.setString(7, item.getCondition());
				pstmt.setInt(8, item.getItemId());
				pstmt.executeUpdate();
				System.out.println("sql => " + sql);
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
			return item;
		}
		
//		*********************************************************************************************************
//		DELETE SERVICES *****************************************************************************************
//		*********************************************************************************************************	
		/**
		 * @param id
		 * void
		 * This method deletes an item from then database based on the id number, which is received as a PathParam
		 */
//		@GET
		@DELETE
		@Path("/deleteitem/{id}")
//		@Produces(MediaType.APPLICATION_JSON)//Method returns object as a JSON string
//		@Consumes(MediaType.APPLICATION_JSON)//Method receives object as a JSON string
		public boolean deleteItem(@PathParam("id") int id) {
			System.out.println("public void deleteItem(@PathParam(\"id\") int id) {");
			boolean removed = false; //Will be returned at the end -> feedback
			String sql="DELETE FROM item WHERE itemId=?";
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
			// Delete item
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
		@Path("/deletejsonitem")
		@Produces(MediaType.APPLICATION_JSON)//Method returns object as a JSON string
		@Consumes(MediaType.APPLICATION_JSON)//Method receives object as a JSON string
		public boolean deleteJsonItem(Item item) {
			System.out.println("public void deleteJsonItem(Item item) {");
			boolean removed = false; //Will be returned at the end -> feedback
			String sql="DELETE FROM item WHERE itemId=?";			
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
				pstmt.setInt(1, item.getItemId());
				pstmt.execute();
				// Verifying Removal
				if (pstmt.getUpdateCount() == 1) { // Return the affected number of rows
					removed = true;
					System.out.println("successfully deleted");
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