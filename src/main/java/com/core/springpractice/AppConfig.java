package com.core.springpractice;

import com.core.springpractice.discount.FixDiscountPolicy;
import com.core.springpractice.member.MemberService;
import com.core.springpractice.member.MemberServiceImpl;
import com.core.springpractice.member.MemoryMemberRepository;
import com.core.springpractice.order.OrderService;
import com.core.springpractice.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository()) {
        };
    }
    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
 }
