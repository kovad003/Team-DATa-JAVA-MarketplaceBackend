// DATA CLASS FOR LOGIN:
package data;

import java.sql.Timestamp;

/**
 * @author Ash
 *	Data class for "customer" table with the purpose of user authentication
 */
public class Login {
    // Attributes
	private int id;
	private String password;

    // Getters / Setters
	public int getUserId() {
		return id;
	}
	public void setUserId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
