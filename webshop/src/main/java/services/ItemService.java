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
//		*********************************************************************************************************
//		POST SERVICES *******************************************************************************************
//		*********************************************************************************************************
		@POST
		@Produces(MediaType.APPLICATION_JSON) //Method returns object as a JSON string
		@Consumes("application/x-www-form-urlencoded") //Method can receive POSTed data from a html form
		@Path("/additem")
		public Item addDogBreedByPost(
				@FormParam("name") String name, 
				@FormParam("price") float price, 
				@FormParam("description") String description, 
				@FormParam("category") String category) {
			Item item=new Item();
			item.setName(name);
			item.setPrice(price);
			item.setDescription(description);
			item.setCategory(category);
			
			String sql="INSERT INTO item (name, price, description, category) VALUES(?,?,?,?)";
			
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
				pstmt.setString(1, name);
				pstmt.setFloat(2,  price);
				pstmt.setString(3, description);
				pstmt.setString(4, category);
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
		public Item receiveJsonItem(Item item) {
			System.out.println("public Item receiveJsonItem(Item item) {");
			String sql="INSERT INTO item (name, price, description, category) VALUES(?,?,?,?)";
			
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
				pstmt.setString(1, item.getName());
				pstmt.setFloat(2,  item.getPrice());
				pstmt.setString(3, item.getDescription());
				pstmt.setString(4, item.getCategory());
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
			
			item.setName(item.getName());
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
		public void deleteItem(@PathParam("id") int id) {
			System.out.println("public void deleteItem(@PathParam(\"id\") int id) {");
			
			String sql="DELETE FROM item WHERE id=?";			
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
		}
		
		@DELETE
		@Path("/deletejsonitem")
		@Produces(MediaType.APPLICATION_JSON)//Method returns object as a JSON string
		@Consumes(MediaType.APPLICATION_JSON)//Method receives object as a JSON string
		public void deleteJsonItem(Item item) {
			System.out.println("public void deleteJsonItem(Item item) {");
			
			String sql="DELETE FROM item WHERE id=?";			
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
				pstmt.setInt(1, item.getId());
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
		}
		
//		*********************************************************************************************************
//		GET SERVICES ********************************************************************************************
//		*********************************************************************************************************
		/**
		 * @return ArrayList<Item> list
		 */
		@GET
		@Produces(MediaType.APPLICATION_JSON)//Method returns object as a JSON string
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
					item.setId(RS.getInt("id"));
					item.setName(RS.getString("name"));
					item.setPrice(RS.getString("price"));
					item.setDescription(RS.getString("description"));
					item.setCategory(RS.getString("category"));
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
//					e.printStackTrace();
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
			String sql = "SELECT * FROM item WHERE id = ?;";
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
					item.setId(RS.getInt("id"));
					item.setName(RS.getString("name"));
					item.setPrice(RS.getString("price"));
					item.setDescription(RS.getString("description"));
					item.setCategory(RS.getString("category"));
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
//					e.printStackTrace();
				}
			}
			return item;
		}
		
//		*********************************************************************************************************
//		PUT SERVICES ********************************************************************************************
//		*********************************************************************************************************
		@PUT
		@Consumes(MediaType.APPLICATION_JSON) //Method takes object as a JSON string
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/updatejsonitem")
		public Item updateItem(Item item) {
			System.out.println("public Item updateItem(Item item) {");
			System.out.println("item => " + item);
			
			String sql = "UPDATE item SET "
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
				pstmt.setString(1, item.getName());
				pstmt.setFloat(2, item.getPrice());
				pstmt.setString(3, item.getDescription());
				pstmt.setString(4, item.getCategory());
				pstmt.setInt(5, item.getId());
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
//					e.printStackTrace();
				}
			}
			return item;
		}
}