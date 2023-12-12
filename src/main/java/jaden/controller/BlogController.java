package jaden.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jaden.model.BlogPost;
import jaden.repository.BlogPostRepository;

import java.util.List;

@Controller
public class BlogController {

    private final BlogPostRepository blogRepository;

    public BlogController(BlogPostRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @GetMapping("/blog")
    public String blog(Model model) {
        List<BlogPost> blogs = blogRepository.findAll();
        model.addAttribute("blogs", blogs);
        return "blog";
    }

    @PostMapping("/blogSearch")
    public String search(@RequestParam String searchTerm, Model model) {
        List<BlogPost> searchResults = blogRepository.findByContentContaining(searchTerm);
        model.addAttribute("blogs", searchResults);
        model.addAttribute("searchTerm", searchTerm);
        return "blogSearch";
    }
}
