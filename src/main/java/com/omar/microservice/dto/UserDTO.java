/**
 * 
 */
package com.omar.microservice.dto;

/**
 * @author Omar
 *
 */

public class UserDTO { // NOSONAR

	private long id;
	private String username;
	private String name;
	private String email;

	public UserDTO() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
