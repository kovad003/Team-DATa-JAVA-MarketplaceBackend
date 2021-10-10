package services;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.appengine.api.utils.SystemProperty;
import java.sql.Statement;

import conn.Connections;
import data.Location;

/**
 * @author Dan
 *	This class contains all the service related to the city and region tables.
 */
@Path("/locationservice")
public class LocationService {
//		*********************************************************************************************************
//		GET SERVICES ********************************************************************************************
//		*********************************************************************************************************
		/**
		 * @return list of ArrayList<Location> type containing region data only
		 */
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/getallregion")
		public ArrayList<Location> getAllRegion() {
			System.out.println("public ArrayList<Item> getAllRegion() {");
			String sql = "SELECT * FROM region";
			ResultSet RS = null;
			ArrayList<Location> list = new ArrayList<>();
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
					Location location = new Location();
					location.setRegionId(RS.getInt("regionId"));
					location.setRegionName(RS.getString("regionName"));
					list.add(location);
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
		 * @return list of ArrayList<Location> type containing all the cities registered in a specific region
		 */
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/getallcityfromregion/{regionId}")
		public ArrayList<Location> getAllCityFromRegion(@PathParam("regionId") int regionId) {
			System.out.println("public ArrayList<Location> getAllCityFromRegion(regionId) {");
			String sql = "SELECT cityId, city.regionId, cityName, regionName, latitude, longitude" + 
					" FROM city LEFT JOIN region" +
					" ON city.regionId = region.regionId" +
					" WHERE city.regionId = ?;";
			System.out.println("SQL: " + sql);
			ResultSet RS = null;
			ArrayList<Location> list = new ArrayList<>();
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
				pstmt.setInt(1, regionId);
				RS = pstmt.executeQuery();
				while (RS.next()) {
					Location location = new Location();
					location.setCityId(RS.getInt("cityId"));
					location.setRegionId(RS.getInt("regionId"));
					location.setCityName(RS.getString("cityName"));
					location.setCityName(RS.getString("regionName"));
					location.setLatitude(RS.getFloat("latitude"));
					location.setLongitude(RS.getFloat("longitude"));
					list.add(location);
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
			return list;
		}
		
		/**
		 * @return list of ArrayList<Location> type containing all the cities registered in a specific region
		 */
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/getcity/{cityId}")
		public Location getCity(@PathParam("cityId") int cityId) {
			System.out.println("public ArrayList<Location> getAllCityFromRegion(regionId) {");
			String sql = "SELECT cityId, city.regionId, cityName, regionName, latitude, longitude" + 
					" FROM city LEFT JOIN region" + 
					" ON city.regionId = region.regionId" + 
					" WHERE city.cityId = ?;";
			ResultSet RS = null;
			Connection conn = null;
			Location location = new Location();
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
				pstmt.setInt(1, cityId);
				RS = pstmt.executeQuery();
				while (RS.next()) {
					location.setCityId(RS.getInt("cityId"));
					location.setRegionId(RS.getInt("regionId"));
					location.setCityName(RS.getString("cityName"));
					location.setRegionName(RS.getString("regionName"));
					location.setLatitude(RS.getFloat("latitude"));
					location.setLongitude(RS.getFloat("longitude"));
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
			return location;
		}	
	}