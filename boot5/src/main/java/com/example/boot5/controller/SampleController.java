package com.example.boot5.controller;

import com.example.boot5.domain.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Member;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SampleController {
    @GetMapping("/sample1")
    public void sample1(Model model) {
        model.addAttribute("greeting", "Hello World");
    }

    @GetMapping("/sample2")
    public void sample2(Model model) {
        MemberVO vo = new MemberVO(123, "u00", "p00", "호일동", new Timestamp(System.currentTimeMillis()));
        model.addAttribute("vo", vo);
    }

    @GetMapping("/sample3")
    public void sample3(Model model) {
        List<MemberVO> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(new MemberVO(123, "u0" + i, "p0" + i, "호일동" + i, new Timestamp(System.currentTimeMillis())));
        }
        model.addAttribute("list", list);
    }

    @GetMapping("/sample4")
    public void sample4(Model model) {
        List<MemberVO> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new MemberVO(i, "u000" + i % 3, "p0000" + i % 3, "호일동" + i, new Timestamp(System.currentTimeMillis())));
        }
        model.addAttribute("list", list);
    }
}
