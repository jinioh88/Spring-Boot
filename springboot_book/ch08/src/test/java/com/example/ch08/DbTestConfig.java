package com.example.ch08;

import com.example.ch08.config.DbConfig;
import com.example.ch08.repository.UserRepository;
import com.example.ch08.vo.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DbConfig.class, loader = AnnotationConfigContextLoader.class)
@Rollback
public class DbTestConfig {
    UserRepository userRepository;

    DbTestConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    public void testList() {
        System.out.println(userRepository.findAll());
    }

    @Test
    public void createUser() {
        UserVO userVO = new UserVO();
        userVO.setId("jpub115");
        userVO.setUserName("고길동");
        userVO.setPwd("!234");
        userRepository.save(userVO);

        System.out.println(userRepository.findByUserName("고길동"));
    }
}
