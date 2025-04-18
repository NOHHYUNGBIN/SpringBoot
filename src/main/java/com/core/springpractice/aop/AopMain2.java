package com.core.springpractice.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootApplication
public class AopMain2 {
    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(Config.class);
        MyMath myMath = ac.getBean(MyMath.class);
        myMath.add(3,5);
        myMath.add(1,2,3);
        System.out.println("myMath.multiply(3,5) = " + myMath.multiply(3, 5));
    }
}
@EnableAspectJAutoProxy // AOP 자동설정
@ComponentScan
@Configuration
class Config {
    
}

@Component
@Aspect
class LoggingAdvice {
    @Around("execution(* com.core.springpractice.aop.MyMath.add*(..))")
    public Object methodClassLog(ProceedingJoinPoint pjp) throws Throwable {
        // target의 메서드 시작 부분에 추가될코드
        System.out.println("<<[start]"+pjp.getSignature().getName() + Arrays.toString(pjp.getArgs()));
        long start = System.currentTimeMillis();

        Object result = pjp.proceed();

        System.out.println("result = " + result);
        System.out.println("[end]>>" + pjp.getSignature().getName() + " " + (System.currentTimeMillis() - start)+"ms");
        // target의 메서드 끝 부분에 추가될코드
        return result;
    }
}
@Component
class MyMath {
    int add(int a, int b) {
        return a + b;
    }
    int add(int a, int b, int c) {
        return a + b + c;
    }
    int subject(int a, int b) {
        return a - b;
    }
    int multiply(int a, int b) {
        return a * b;
    }
}
