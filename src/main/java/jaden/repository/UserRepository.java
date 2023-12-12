// package
package jaden.repository;

// imports
import org.springframework.data.jpa.repository.JpaRepository;

import jaden.model.User;

//sets up user repository
public interface UserRepository extends JpaRepository<User, Long> {
	// sets up find by username and password
	User findByUsernameAndPassword(String username, String password);

	// sets up find by username
	User findByUsername(String username);
}
