// DATA CLASS FOR LOGIN:
package data;

import java.sql.Timestamp;

/**
 * @author Ash
 *	Data class for "customer" table with the purpose of user authentication
 */
public class Login {
    // Attributes
	private int customerId;
	private String userName;
	private String password;
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
