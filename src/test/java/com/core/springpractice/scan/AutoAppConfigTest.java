package com.core.springpractice.scan;

import com.core.springpractice.AutoAppConfig;
import com.core.springpractice.member.MemberRepository;
import com.core.springpractice.member.MemberService;
import com.core.springpractice.order.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {
    @Test
    void basicScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        System.out.println("memberService = " + memberService);

        OrderService orderService = ac.getBean(OrderService.class);
        System.out.println("orderService = " + orderService);

        MemberRepository memberRepository = ac.getBean(MemberRepository.class);
        System.out.println("memberRepository = " + memberRepository);
    }
}
