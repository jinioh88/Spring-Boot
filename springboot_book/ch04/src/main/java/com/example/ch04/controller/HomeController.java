package com.example.ch04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {
    @RequestMapping(value = "/th")
    public String templatePage(Model model) {
        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("color","red");
        pageMap.put("name","jam");

        model.addAttribute("pageMap", pageMap);
        return "th2";
    }
}
