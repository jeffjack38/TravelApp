package jaden.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jaden.model.User;
import jaden.service.AuthService;
import jaden.service.UserService;

//UserController.java
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthService authService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	 @GetMapping({"", "/index"})
	    public String index() {
	        return "index";
	    }

	@PostMapping("/login")
	public String loginUser(@RequestParam String username, @RequestParam String password,
	        RedirectAttributes attributes) {
	    // Check credentials using AuthService
	    boolean loginSuccessful = authService.authenticate(username, password);

	    if (loginSuccessful) {
	        // Redirect to dashboard with username parameter
	        return "redirect:/dashboard?username=" + username;
	    } else {
	        // Add an error message to be displayed on the login page
	        attributes.addFlashAttribute("error", "Incorrect username or password");
	        return "redirect:/login";
	    }
	}


	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:/login?success";
	}

    @GetMapping("/dashboard")
    public String dashboard(Model model, @RequestParam String username) {
        model.addAttribute("username", username);
        return "dashboard";

    }
}
