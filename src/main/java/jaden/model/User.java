// package
package jaden.model;

// imports
import java.io.Serializable;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// sets up database
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

	// sets up id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// sets up username
	@Column(nullable = false, unique = true)
	private String username;

	// sets up password
	@Column(nullable = false)
	private String password;

	/**
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	// no args constructor
	public User() {
		super();
	}

	// username
	public User(String username) {
		super();
		this.username = username;
	}

	// all args
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

}