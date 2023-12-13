// package
package jaden.repository;

// imports
import org.springframework.data.jpa.repository.JpaRepository;

import jaden.model.BlogPost;

import java.util.List;

// repository set up
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

	// allows for searching
	List<BlogPost> findByContentContaining(String searchTerm);

}
