package com.core.springpractice;

import com.core.springpractice.discount.DiscountPolicy;
import com.core.springpractice.discount.FixDiscountPolicy;
import com.core.springpractice.discount.RateDiscountPolicy;
import com.core.springpractice.member.MemberRepository;
import com.core.springpractice.member.MemberService;
import com.core.springpractice.member.MemberServiceImpl;
import com.core.springpractice.member.MemoryMemberRepository;
import com.core.springpractice.order.OrderService;
import com.core.springpractice.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(getMemberRepository());
    }
    @Bean
    public MemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(getMemberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
 }
