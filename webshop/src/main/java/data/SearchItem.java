package data;

/**
 * @author Dan
 *	Data class for "item" table
 */
public class SearchItem {
// SEARCH PARAMS ----------------------------------------
	private String categoryTitle;
	private String itemTitle;
	private float minPrice;
	private float maxPrice;
	private String condition;
	private String location;
	
	
	public String getCategoryTitle() {
		return categoryTitle;
	}
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}
	public String getItemTitle() {
		return itemTitle;
	}
	public void setItemTitle(String title) {
		this.itemTitle = title;
	}
	public float getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(float price) {
		this.minPrice = price;
	}
	public float getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(float maxPrice) {
		this.maxPrice = maxPrice;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
