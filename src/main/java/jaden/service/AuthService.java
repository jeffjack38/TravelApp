// package
package jaden.service;

// imports
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jaden.model.User;
import jaden.repository.UserRepository;

// sets up service
@Service
public class AuthService {

	// connects user repository
	@Autowired
	private UserRepository userRepository;

	// makes sure the user and password are in the database
	public boolean authenticate(String username, String password) {
		// Check against the database using UserRepository
		User user = userRepository.findByUsernameAndPassword(username, password);

		return user != null;
	}
}
