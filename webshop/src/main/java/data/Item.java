package data;

import java.sql.Timestamp;

/**
 * @author Dan
 *	Data class for "item" table
 */
public class Item {
	private int itemId;
	private int categoryId;
	private String categoryTitle; // For joint table (item + category)
	private int customerId;
	private String title;
	private float price;
	private String description;
	private String image;
	private String condition;
	private String location;
	private Timestamp datePosted;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryTitle() {
		return categoryTitle;
	}
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setPrice(String stringPrice) {
		try {
			this.price = Float.parseFloat(stringPrice);
		}
		catch(NumberFormatException e) {
			price=-1;
		}
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public Timestamp getDatePosted() {
		return datePosted;
	}
	public void setDatePosted(Timestamp datePosted) {
		this.datePosted = datePosted;
	}
	public String toString() {
		return itemId+" "+categoryId +" "+customerId+" "+" "+title+" "+price+" "+description+" "+condition+" "+datePosted+"\n";
	}
}
