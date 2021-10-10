package data;


public class Category {
	private String id;
	private String title;
	private String color;
	private String description;
	private String imageUrl;
	
	// constructor
	public Category(String id, String title, String color,  String description, String imageUrl) {
		super();
		this.id = id;
		this.title = title;
		this.color = color;
		this.description = description;
		this.imageUrl = imageUrl;
	}
	
	public Category() {
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String image) {
		this.imageUrl = image;
	}

	
}
