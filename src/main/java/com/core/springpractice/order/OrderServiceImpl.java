package com.core.springpractice.order;

import com.core.springpractice.discount.DiscountPolicy;
import com.core.springpractice.discount.FixDiscountPolicy;
import com.core.springpractice.discount.RateDiscountPolicy;
import com.core.springpractice.member.Member;
import com.core.springpractice.member.MemberRepository;
import com.core.springpractice.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
