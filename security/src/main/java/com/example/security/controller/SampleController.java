package com.example.security.controller;

import lombok.extern.java.Log;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log
public class SampleController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/guest")
    public void forGuest() {
        log.info("gurest");
    }

    @RequestMapping("/manager")
    public void forManager() {
        log.info("manager");
    }

    @RequestMapping("/admin")
    public void forAdmin() {
        log.info("admin");
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping("/adminSec")
    public void forAdminSec() {

    }
}
