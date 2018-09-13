package com.example.security.controller;

import com.example.security.domain.Member;
import com.example.security.persistence.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/")
public class MemberController {
    @Autowired
    PasswordEncoder pwEncoder;

    @Autowired
    MemberRepository repository;

    @GetMapping("/join")
    public void join() {}

    @PostMapping("/join")
    public String joinPost(@ModelAttribute("member") Member member) {
        String encryptPw = pwEncoder.encode(member.getUpw());
        member.setUpw(encryptPw);
        repository.save(member);
        return "/member/joinResult";
    }
}
