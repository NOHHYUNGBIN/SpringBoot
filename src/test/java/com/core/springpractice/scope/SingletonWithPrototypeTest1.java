package com.core.springpractice.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Provider;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class SingletonWithPrototypeTest1 {

    @Test
    void prototypeFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean protoTypeBean1 = ac.getBean(PrototypeBean.class);
        protoTypeBean1.addCount();
        Assertions.assertThat(protoTypeBean1.getCount()).isEqualTo(1);

        PrototypeBean protoTypeBean2 = ac.getBean(PrototypeBean.class);
        protoTypeBean2.addCount();
        Assertions.assertThat(protoTypeBean2.getCount()).isEqualTo(1);
    }

    @Test
    void SingletonClientUsePrototype() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();

        Assertions.assertThat(count1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();

        Assertions.assertThat(count2).isEqualTo(1);

    }

    @Scope("singleton")
    @Component
    static class ClientBean {
//        private final PrototypeBean protoTypeBean; //생성시점에 주입
//
//        @Autowired
//        public ClientBean(PrototypeBean protoTypeBean) {
//            this.protoTypeBean = protoTypeBean;
//        }
//        public int logic() {
//            protoTypeBean.addCount();
//            int count = protoTypeBean.getCount();
//            return count;
//        }
//
//        private int getCount() {
//            return protoTypeBean.getCount();
//        }
//        @Autowired
//        private ObjectProvider<PrototypeBean> prototypeBeanProvider;
//        public int logic() {
//            PrototypeBean protoTypeBean = prototypeBeanProvider.getObject();
//            protoTypeBean.addCount();
//            int count = protoTypeBean.getCount();
//            return count;
//        }
        @Autowired
        private Provider<PrototypeBean> prototypeBeanProvider;

        public int logic() {
            PrototypeBean protoTypeBean = prototypeBeanProvider.get();
            protoTypeBean.addCount();
            int count = protoTypeBean.getCount();
            return count;
        }
    }

    @Scope("prototype")
    @Component
    static class PrototypeBean {
        private int count = 0;

        public void addCount() {
            count++;
        }
        public int getCount() {
            return count;
        }
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean init " + this);
        }
        @PreDestroy
        public void close() {
            System.out.println("PrototypeBean close");
        }
    }
}
