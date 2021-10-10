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
import conn.Connections;
import data.Region;
import data.City;

/**
 * @author Dan
 *	This class contains all the service related to the city and region tables.
 */
@Path("/cityservice")
public class CityService {
//		*********************************************************************************************************
//		GET SERVICES ********************************************************************************************
//		*********************************************************************************************************
		
		/**
		 * @return list of ArrayList<Location> type containing all the cities registered in a specific region
		 */
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/getcity/{cityId}")
		public City getCity(@PathParam("cityId") int cityId) {
			System.out.println("public City getCity(@PathParam(\"cityId\") int cityId) {");
			String sql = "SELECT cityId, city.regionId, cityName, regionName, latitude, longitude" + 
					" FROM city LEFT JOIN region" + 
					" ON city.regionId = region.regionId" + 
					" WHERE city.cityId = ?;";
			ResultSet RS = null;
			Connection conn = null;
			City city = new City();
			Region region = new Region();
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
					// Region data
					region.setRegionId(RS.getInt("regionId"));
					region.setRegionName(RS.getString("regionName"));
					// City data
					city.setCityId(RS.getInt("cityId"));					
					city.setCityName(RS.getString("cityName"));
					city.setLatitude(RS.getFloat("latitude"));
					city.setLongitude(RS.getFloat("longitude"));
					city.setRegionData(region);
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
			return city;
		}	
	}