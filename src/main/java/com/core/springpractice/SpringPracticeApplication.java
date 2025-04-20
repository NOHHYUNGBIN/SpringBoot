package com.core.springpractice;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringPracticeApplication implements CommandLineRunner {
    @Autowired
    EntityManagerFactory emf;
    public static void main(String[] args) {

//        SpringApplication.run(SpringPracticeApplication.class, args);

        //톰캣이 안뜨도록 설정변경
        SpringApplication app = new SpringApplication(SpringPracticeApplication.class);
//        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("emf = " + emf);
    }
}