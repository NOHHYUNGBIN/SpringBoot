package com.core.springpractice.beanfind;

//import com.core.springpractice.AppConfig;
import com.core.springpractice.AutoAppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

    @Test
    @DisplayName("모든 빈 출력해보기")
    void findAllBean() {
        String[] beans = ac.getBeanDefinitionNames();
        for (String bean : beans) {
            Object beanInfo = ac.getBean(bean);
            System.out.println("beanInfo = " + beanInfo);
        }
    }
}
