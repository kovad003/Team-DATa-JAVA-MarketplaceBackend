package services;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.appengine.api.utils.SystemProperty;
import conn.Connections;
import data.Item;
import data.SearchItem;
/**
 * @author Dan
 *	This class contains all the service related to the item table.
 */
@Path("/searchservice")

public class SearchService {

//		*********************************************************************************************************
//		POST SERVICES *******************************************************************************************
//		*********************************************************************************************************
		/**
		 * @param Item item
		 * @return item
		 * This method receives values from an html form which sends a POST type request.
		 */
		@POST // GET cannot consume any entity
		@Consumes(MediaType.APPLICATION_JSON)//Method receives object as a JSON string
		@Produces(MediaType.APPLICATION_JSON)//Method returns object as a JSON string
		@Path("/searchforitems")
		public ArrayList<Item> searchForItems(SearchItem searchItem) {
			System.out.println("public ArrayList<Item> searchForItems(Item item) {");
			PreparedStatement pstmt;
			ResultSet RS = null;
			ArrayList<Item> list = new ArrayList<Item>(); // list to be returned
			
			String sql="SELECT * FROM item LEFT JOIN category ON category.id = item.categoryId WHERE"
					/*1*/ + " item.price >= ?" //Min price
					/*2*/ + " AND item.price <= ?" //Max price
					/*3*/ + " AND item.title = ?"
					/*4*/ + " AND `condition` = ?"
					/*5*/ + " AND category.title = ?"
					/*6*/ + " AND location = ?;";
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
			try {
				pstmt = conn.prepareStatement(sql);
				/*1*/ pstmt.setFloat(1, searchItem.getMinPrice());
				/*2*/ pstmt.setFloat(2, searchItem.getMaxPrice());
				/*3*/ pstmt.setString(3, searchItem.getItemTitle());
				/*4*/ pstmt.setString(4,  searchItem.getCondition());			
				/*5*/ pstmt.setString(5, searchItem.getCategoryTitle());
				/*6*/ pstmt.setString(6, searchItem.getLocation());
				RS = pstmt.executeQuery(); // executeQuery() returns an 'actual' ResultSet (execute() only returns a boolean as RS)
			
				while(RS.next()) {
					Item item = new Item();
					item.setItemId(RS.getInt("itemId"));
					item.setCategoryId(RS.getInt("categoryId"));
					item.setCategoryTitle(RS.getString("category.title"));					
					item.setCustomerId(RS.getInt("customerId"));
					item.setTitle(RS.getString("item.title"));
					item.setPrice(RS.getString("price"));
					item.setDescription(RS.getString("description"));
					item.setImage(RS.getString("image"));
					item.setCondition(RS.getString("condition"));
					item.setLocation(RS.getString("location"));
					item.setDatePosted(RS.getTimestamp("datePosted"));
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
			
			//item.setTitle(item.getTitle());
			System.out.println("List: " + list);
			return list;
		}
}