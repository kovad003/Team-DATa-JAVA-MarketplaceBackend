package data;


public class Customer {

	private int customerId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;	
	private String dateOfBirth ;
	private String email;
	private String phone;
	private String image;
	
	// constructor
	public Customer(int customerId, String firstName, String lastName,  String userName,  String password, String dateOfBirth,  String email,String phone, String image) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.phone = phone;
		this.image = image;
	}


	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastFamily() {
		return lastName;
	}

	public void setLastFamily(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	
	
}
