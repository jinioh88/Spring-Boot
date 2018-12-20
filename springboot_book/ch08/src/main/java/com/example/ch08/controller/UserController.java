package com.example.ch08.controller;

import com.example.ch08.exception.UserNotFoundException;
import com.example.ch08.service.UserService;
import com.example.ch08.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public ResponseEntity<?> registUser(@Validated @RequestBody UserVO userVO) {
        System.out.println("controller vo check::"+userVO.toString());
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping("/{username}")
    public ResponseEntity<?> findByUserOne(@PathVariable("username") String userName) {
        UserVO user = userService.findByOneUserName(userName);

        if(user == null) {
            throw new UserNotFoundException("user not found");
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}

