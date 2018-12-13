package com.example.ch04;

import com.example.ch04.config.MyAnnotation;
import com.example.ch04.importSelect.MainConfig;
import com.example.ch04.importSelect.UseMyBean;
import com.example.ch04.model.UserEntity;
import com.example.ch04.model.UserRole;
import com.example.ch04.repository.UserRepository;
import com.example.ch04.service.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Method;

//@SpringBootApplication
public class Ch04Application {

    public static void main(String[] args) throws ClassNotFoundException {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        UseMyBean bean = context.getBean(UseMyBean.class);
        bean.printMsg();
//        UserRepository userRepository = context.getBean(UserRepository.class);
//
//        userRepository.save(new UserEntity("오사장", 31, UserRole.ADMIN));
//        UserEntity user = userRepository.findByUserName("오사장");
//        System.out.println("나이 : "+user.getAge()+", "+"이름 : "+user.getUserName() + ", " + "생성일: "+user.getCreatedAt());
    }
}
