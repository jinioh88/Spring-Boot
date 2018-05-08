package net.slip.web;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	
	List<User> users = new ArrayList<>();
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("/create")
	public String create(User user) {
		System.out.println(user);
		if(user!=null) {
			users.add(user);
		}
		return "redirect:list";  //template
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("users",users);
		return "list";
	}
}
