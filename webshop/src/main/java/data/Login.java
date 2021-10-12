// DATA CLASS FOR LOGIN:
package data;

import java.sql.Timestamp;

/**
 * @author Ash
 *	Data class for "customer" table with the purpose of user authentication
 */
public class Login {
    // Attributes
	//private int id;
	private int customerId;
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

    /* Getters / Setters
	public int getUserId() {
		return id;
	}
	public void setUserId(int customerId) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	*/

}
