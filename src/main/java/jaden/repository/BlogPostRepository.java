package jaden.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jaden.model.BlogPost;

import java.util.List;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

	List<BlogPost> findByContentContaining(String searchTerm);

}

