package net.slip.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.slip.domain.User;
import net.slip.domain.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();

    @Autowired
    private UserRepository repo;

    @GetMapping("/form")
    public String form() {

        return "/user/form";
    }

    @PostMapping
    public String add(User user) {
        users.add(user);
        repo.save(users);
        return "redirect:/users";
    }

    @GetMapping
    public String list(Model model, HttpSession session) {
        model.addAttribute("users", repo.findAll());
        return "/user/list";
    }

    @GetMapping("/{id}/form")
    public String updateForm(@PathVariable Long id, Model model, HttpSession session) {
        Object tempUser = session.getAttribute(HttpSessionUtils.USER_SESSION_KEY);
        if (HttpSessionUtils.isLoginUser(session)) {
            return "redirect:/users/loginForm";
        }

        User sessionUser = HttpSessionUtils.getUserFormSession(session);
        if (!sessionUser.matchId(id))
            throw new IllegalStateException("not matched User");

        model.addAttribute("user", repo.findOne(id));
        return "/user/updateForm";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, User newUser) {
        User user = repo.findOne(id);
        user = newUser;
        user.setId(id);
        System.out.println(user);
        repo.save(user);
        return "redirect:/users";
    }

    @GetMapping("/loginForm")
    public String loginForm() {

        return "/user/login";
    }

    @PostMapping("/login")
    public String login(String userId, String password, HttpSession session) {
        User user = repo.findByUserId(userId);
        if (user == null) {
            return "redirect:/users/loginForm";
        }
        if (!password.equals(user.getPassword())) {
            System.out.println("비밀번호 불일치");
            return "redirect:/users/loginForm";
        }
        System.out.println("로그인 성공!");
        session.setAttribute(HttpSessionUtils.USER_SESSION_KEY, user);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        User user = (User) session.getAttribute(HttpSessionUtils.USER_SESSION_KEY);
        System.out.println(user.getName() + " 로그아웃");
        session.removeAttribute(HttpSessionUtils.USER_SESSION_KEY);
        return "redirect:/";
    }

}
