package data;


public class Category {
	private int id;
	private String title;
	private String description;
	private String imageUrl;
	
	
	
	
	
	public Category(int id, String title, String description, String imageUrl) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.imageUrl = imageUrl;
	}
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
