package net.slip.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.slip.domain.Question;
import net.slip.domain.QuestionRepository;
import net.slip.domain.User;

@Controller
@RequestMapping("/qna")
public class QuestionController {
	@Autowired
	QuestionRepository questionRepository;

	@GetMapping("/form")
	public String qForm(HttpSession session) {
		if(!HttpSessionUtils.isLoginUser(session))
			return "/users/loginForm";
		
		return "/qna/form";
	}
	
	@PostMapping("")
	public String create(String title, String contents, HttpSession session) {
		if(!HttpSessionUtils.isLoginUser(session))
			return "/users/loginForm";
		
		User sessionUser = HttpSessionUtils.getUserFormSession(session);
		Question newQuestion = new Question(sessionUser.getUserId(),title,contents);
		questionRepository.save(newQuestion);
		return "redirect:/";
	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable Long id, Model model) {
		Question question = questionRepository.findOne(id);
		model.addAttribute("question",question);
		return "/qna/show";
	}
}
