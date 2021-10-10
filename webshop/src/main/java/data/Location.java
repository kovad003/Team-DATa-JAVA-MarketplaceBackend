package data;

/**
 * @author Dan
 *	Data class for "city" and "region" tables. The two tables are mostly used as joint ones.
 */
public class Location {
	private int cityId;
	private int regionId;
	private String cityName;
	private String regionName;
	private float latitude;
	private float longitude;
	
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	
	public int getCityId() {
		return cityId;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
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
}
