package data;

import java.util.ArrayList;

/**
 * @author Dan
 *	Data class for "region" table.
 */
public class Region {
//	*******************************************************************************************
//	PROPERTIES ********************************************************************************
//	*******************************************************************************************
//	From region table --------------------
	private int regionId;
	private String regionName;
//	--------------------------------------
//	From city table ----------------------
	private ArrayList<City> regionCities; // Can be amended with available cities in the region
//	--------------------------------------
	
//	*******************************************************************************************
//	SETTERS/GETTERS ***************************************************************************
//	*******************************************************************************************
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public ArrayList<City> getRegionCities() {
		return regionCities;
	}
	public void setRegionCities(ArrayList<City> regionCities) {
		this.regionCities = regionCities;
	}
}
