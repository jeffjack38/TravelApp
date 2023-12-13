// package
package jaden.controller;

// imports
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

//creates User Controller
@Controller
public class UserController {

	// sets up user Service
	@Autowired
	private UserService userService;

	// sets up authorization
	@Autowired
	private AuthService authService;

	// sets up index
	@GetMapping({ "", "/index" })
	public String index() {
		return "index";
	}

	// sets up how to get to login
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	// sets up post mapping for index
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

	// sets up get register
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	// sets up post mapping for register
	@PostMapping("/register")
	public String register(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:/login?success";
	}

	// sets up dashboard
	@GetMapping("/dashboard")
	public String dashboard(Model model, @RequestParam String username) {
		model.addAttribute("username", username);
		return "dashboard";

	}
}
