package web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}


	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC-SECURITY application");
		messages.add("5.2.12 version by dec'20 ");
		model.addAttribute("messages", messages);
		return "hello";
	}

	@GetMapping(value = "/login")
	public String loginPage() {
		return "login";
	}

	@GetMapping("/user")
	public String getUserInfo(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("userData", userService.getUserByName(auth.getName()));

		return "user";
	}

	@GetMapping("/admin")
	public String getAllUsers(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("userData", userService.getUserByName(auth.getName()));
		model.addAttribute("users", userService.getAllUsers());
		model.addAttribute("user", new User());
		model.addAttribute("roles", userService.getAllRoles());
		return "main";
	}


	@PostMapping("/admin/add")
	public String create(@ModelAttribute("user") User user) {
		userService.saveUser(user);

		return "redirect:/admin";
	}


	@PostMapping("/admin/edit/{id}")
	public String edit(@ModelAttribute("user") User user) {
		userService.editUser(user);

		return "redirect:/admin";
	}

	@GetMapping("/admin/delete/{id}")
	public String deleteUser(@PathVariable("id") int id){
		userService.deleteUser(id);

		return "redirect:/admin";
	}

}