package net.slip.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.slip.domain.QuestionRepository;

@Controller
public class HomeController {
	@Autowired
	private QuestionRepository qrepo;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("question",qrepo.findAll());
		return "index";
	}
}
