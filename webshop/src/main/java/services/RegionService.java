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
import data.Region;
import data.City;

/**
 * @author Dan
 *	This class contains all the service related to the city and region tables.
 */
@Path("/regionservice")
public class RegionService {
//	*********************************************************************************************************
//	GET SERVICES ********************************************************************************************
//	*********************************************************************************************************
	/**
	 * @return list of ArrayList<Location> type containing region data only
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getallregion")
	public ArrayList<Region> getAllRegion() {
		System.out.println("public ArrayList<Region> getAllRegion() {");
		String sql = "SELECT * FROM region";
		ResultSet RS = null;
		ArrayList<Region> list = new ArrayList<>();
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
				Region region = new Region();
				region.setRegionId(RS.getInt("regionId"));
				region.setRegionName(RS.getString("regionName"));
				list.add(region);
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
	 * @return list of ArrayList<Location> type containing all the cities registered in a specific region
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getallcityfromregion/{regionId}")
	public Region getAllCityFromRegion(@PathParam("regionId") int regionId) {
		System.out.println("public Region getAllCityFromRegion(@PathParam(\"regionId\") int regionId) {");
		String sql = "SELECT cityId, city.regionId, cityName, regionName, latitude, longitude" + 
				" FROM city LEFT JOIN region" +
				" ON city.regionId = region.regionId" +
				" WHERE city.regionId = ?;";
		System.out.println("SQL: " + sql);
		ResultSet RS = null;
		Region region = new Region(); // Will be returned at the end
		ArrayList<City> listOfCities = new ArrayList<City>(); // Will be attached to the Region object -> check data.Region class
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
				// City Data
				City city = new City();
				city.setCityId(RS.getInt("cityId"));
//				city.setRegionId(RS.getInt("regionId"));
				city.setCityName(RS.getString("cityName"));
				city.setLatitude(RS.getFloat("latitude"));
				city.setLongitude(RS.getFloat("longitude"));
				listOfCities.add(city);
				// Region Data
				if (RS.isLast()) {
					region.setRegionName(RS.getString("regionName"));
					region.setRegionId(RS.getInt("regionId"));
					region.setRegionCities(listOfCities);
					System.out.println("region data: " + region.getRegionId() +") " + region.getRegionName());
					System.out.println("listOfCities attached: " + listOfCities);
				}		
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
		return region;
	}

}