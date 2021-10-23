package data;


/**
 * @author Hossein and Ash
 * This is for the candidate part of the restful web service
 * This standard java class has been utilised inside of the
 * 'data' package.
 *
 */
public class Customer {

	/**
	 *  customerId - int based value for the customerId column in the customer table.
	 */
	private int customerId;
	/**
	 * firstName - String based value for the firstName column in the customer table.
	 */
	private String firstName;
	/**
	 * lastName - String based value for the lastName column in the customer table.
	 */
	private String lastName;
	/**
	 * userName - String based value for the userName column in the customer table.
	 */
	private String userName;
	/**
	 * password - String based value for the password column in the customer table.
	 */
	private String password;	
	/**
	 * dateOfBirth - String based value for the dateOfBirth column in the customer table.
	 */
	private String dateOfBirth ;
	/**
	 * email - String based value for the email column in the customer table.
	 */
	private String email;
	/**
	 * phone - String based value for the phone column in the customer table.
	 */
	private String phone;
	/**
	 * image - String based value for the image column in the customer table.
	 */
	private String image;
	
	
	/**
	 * Parameterised constructor (some ints, mostly Strings) 
	 * for the customer class
	 * 
	 * @param customerId - int based argument taken for the parameterised constructor
	 * @param firstName - String based argument taken for the parameterised constructor
	 * @param lastName - String based argument taken for the parameterised constructor
	 * @param userName - String based argument taken for the parameterised constructor
	 * @param password - String based argument taken for the parameterised constructor
	 * @param dateOfBirth - String based argument taken for the parameterised constructor
	 * @param email - String based argument taken for the parameterised constructor
	 * @param phone - String based argument taken for the parameterised constructor
	 * @param image - String based argument taken for the parameterised constructor
	 */
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

	
	/**
	 * Customer non-parameterised (default) constructor
	 */
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	/* AD - Setters and Getters */
	
	/**
	 * customerId getter method
	 * @return (int value) from the customer table.
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
	 * firstName getter method
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * firstName setter method
	 * @param firstName - sets the firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * lastName getter method
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * lastName setter method
	 * @param lastName - sets the lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * userName getter method
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * userName setter method
	 * @param userName - sets the userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	/**
	 * password getter method
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * password setter method
	 * @param password - sets the password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * dateOfBirth getter method
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * dateOfBirth setter method
	 * @param dateOfBirth -  sets the dateOfBirth
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * email getter method
	 * @return the email (address)
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * email setter method
	 * @param email - sets the email (address)
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * phone getter method
	 * @return the phone (number)
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * phone setter method
	 * @param phone - sets the phone (number)
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * image getter method
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * image setter method
	 * @param image - the image is returned
	 */
	public void setImage(String image) {
		this.image = image;
	}


	
	
}
