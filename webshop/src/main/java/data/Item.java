package data;

import java.sql.Timestamp;


/**
 * @author Dan and Ash
 * 		This data class is for the item part of the restful 
 *		web service. This standard java class has been utilised 
 *		inside of the 'data' package.
 */
public class Item {
	
	/* AD - Attributes of the Item class */
	
	/**
	 * itemId - int based value for the itemId column in the item table.
	 */
	private int itemId;
	/**
	 * categoryId - int based value for the categoryId column in the item table.
	 */
	private int categoryId;
	/**
	 * categoryTitle - String based value for the categoryTitle column in the item table.
	 */
	private String categoryTitle; // For joint table (item + category)
	/**
	 * customerId - int based value for the customerId column in the item table.
	 */
	private int customerId;
	/**
	 * title - String based value for the title column in the item table.
	 */
	private String title;
	/**
	 * price - float based value for the price column in the item table.
	 */
	private float price;
	/**
	 * description - String based value for the description column in the item table.
	 */
	private String description;
	/**
	 * image - String based value for the image column in the item table.
	 */
	private String image;
	/**
	 * condition - String based value for the condition column in the item table.
	 */
	private String condition;
	/**
	 * location - String based value for the location column in the item table.
	 */
	private String location;
	/**
	 * datePosted - Timestamp based value for the datePosted column in the item table.
	 */
	private Timestamp datePosted;
	
	/* AD - Setters and Getters of the Item class */
	
	/**
	 * itemId getter method
	 * @return itemId - (int value) from the item table.
	 */
	public int getItemId() {
		return itemId;
	}
	/**
	 * itemId setter method
	 * @param itemId setter
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	/**
	 * customerId - getter method
	 * @return - customerId - (int value) from the item table
	 */
	public int getCustomerId() {
		return customerId;
	}
	/**
	 * customerId setter method
	 * @param customerId setter
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	/**
	 * categoryId getter method
	 * @return categoryId - (int value) from the item table
	 */
	public int getCategoryId() {
		return categoryId;
	}
	/**
	 * categoryId setter method
	 * @param categoryId setter
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * categoryTitle getter method 
	 * @return the categoryTitle
	 */
	public String getCategoryTitle() {
		return categoryTitle;
	}
	/**
	 * categoryTitle setter method
	 * @param categoryTitle setter
	 */
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}
	/**
	 * title - getter method
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * title - setter method
	 * @param title setter
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * price getter method
	 * @return price - (float value) from the item table
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * price setter method
	 * @param price setter - (float value)
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * price setter method (parses to String)
	 * @param price takes argument stringPrice
	 */
	public void setPrice(String stringPrice) {
		try {
			this.price = Float.parseFloat(stringPrice);
		}
		catch(NumberFormatException e) {
			price=-1;
		}
	}
	/**
	 * description getter method
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * description setter method
	 * @param description - sets the description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * image getter (might be amended later, if time permits)
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * image setter method
	 * @param image - sets the image
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * condition getter method
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}
	/**
	 * condition setter method
	 * @param condition - sets the condition
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}
	/**
	 * location getter method
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * location setter method
	 * @param location - sets the location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * datePosted getter method
	 * @return the datePosted
	 */
	public Timestamp getDatePosted() {
		return datePosted;
	}
	/**
	 * datePosted setter method
	 * @param datePosted - sets the datePosted
	 */
	public void setDatePosted(Timestamp datePosted) {
		this.datePosted = datePosted;
	}
	/**
	 * Returns a string representation of the object.
	 * In general, the toString method returns a string
	 * that "textually represents" this object.
	 * Thus, here, all of the item data is returned.
	 */
	public String toString() {
		return itemId+" "+categoryId +" "+customerId+" "+" "+title+" "+price+" "+description+" "+condition+" "+datePosted+"\n";
	}
}
