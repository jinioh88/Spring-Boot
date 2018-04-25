package com.example.spring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.spring.domain.Journal;
import com.example.spring.repository.JournalRepository;

@SpringBootApplication
public class DemoApplication {

	@Bean
	InitializingBean saveData(JournalRepository repo) {
		return()->{
			repo.save(new Journal("스프링 부트","공부시작","04/25/2018"));
			repo.save(new Journal("웹","설정","04/25/2018"));
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
