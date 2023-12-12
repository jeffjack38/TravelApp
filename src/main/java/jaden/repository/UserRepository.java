package jaden.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jaden.model.User;

//UserRepository.java
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsernameAndPassword(String username, String password);
	User findByUsername(String username);
}
