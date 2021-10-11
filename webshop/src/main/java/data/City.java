package data;

/**
 * @author Dan
 *	Data class for "city" table.
 */
public class City {
//	*******************************************************************************************
//	PROPERTIES ********************************************************************************
//	*******************************************************************************************
//	From city table ----------------------
	private int cityId;
//	private int regionId; //=> regionData
	private String cityName;
	private float latitude;
	private float longitude;
//	--------------------------------------
//	From region table --------------------
	private Region regionData; // Can be amended with region data if it is required
//	--------------------------------------
	
//	*******************************************************************************************
//	SETTERS/GETTERS ***************************************************************************
//	*******************************************************************************************
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	
	public int getCityId() {
		return cityId;
	}
/*
	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
*/
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public Region getRegionData() {
		return regionData;
	}

	public void setRegionData(Region regionData) {
		this.regionData = regionData;
	}

}
