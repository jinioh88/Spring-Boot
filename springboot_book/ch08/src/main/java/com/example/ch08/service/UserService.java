package com.example.ch08.service;

import com.example.ch08.repository.UserRepository;
import com.example.ch08.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Iterator;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Iterable<UserVO> findAllUserInfo() {
        Iterable<UserVO> allUsers = userRepository.findAll();
        return allUsers;
    }

    public void dummyInfo() {
        ServletUriComponentsBuilder.fromCurrentRequest().toUriString();
    }

    public void createUser(UserVO userVO) {
        System.out.println("userVO::"+userVO.toString());
        userRepository.save(userVO);
    }

    public Iterable<? extends UserVO> findByLikeUserName(String userName) {
        Iterable<? extends UserVO> resultList = userRepository.findByUserName(userName);
        return resultList;
    }

    public UserVO findByOneUserName(String userName) {
        UserVO userVO = userRepository.findOne(userName);
        return userVO;
    }
}
