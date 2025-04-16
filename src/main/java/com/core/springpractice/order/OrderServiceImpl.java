package com.core.springpractice.order;

import com.core.springpractice.discount.DiscountPolicy;
import com.core.springpractice.discount.FixDiscountPolicy;
import com.core.springpractice.discount.RateDiscountPolicy;
import com.core.springpractice.member.Member;
import com.core.springpractice.member.MemberRepository;
import com.core.springpractice.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("rateDiscountPolicy") DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        System.out.println("member = " + member);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        System.out.println("discountPrice = " + discountPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
