package data;


public class Item {
	private int id;
	private String name;
	private float price;
	private String description;
	private String category;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String toString() {
		return id+" "+name+" "+price+" "+description+" "+category+"\n";
	}
}
