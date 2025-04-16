package com.core.springpractice.order;

import com.core.springpractice.AppConfig;
import com.core.springpractice.member.Grade;
import com.core.springpractice.member.Member;
import com.core.springpractice.member.MemberService;
import com.core.springpractice.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long MemberId = 1L;
        Member member = new Member(MemberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(member.getId(),"itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
