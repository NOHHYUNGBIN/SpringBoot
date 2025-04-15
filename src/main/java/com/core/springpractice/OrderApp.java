package com.core.springpractice;

import com.core.springpractice.member.Grade;
import com.core.springpractice.member.Member;
import com.core.springpractice.member.MemberService;
import com.core.springpractice.order.Order;
import com.core.springpractice.order.OrderService;
import com.core.springpractice.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "MemberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA",10000);

        System.out.println("order = " + order);
    }
}
