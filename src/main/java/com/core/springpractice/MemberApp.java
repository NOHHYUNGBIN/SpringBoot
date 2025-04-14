package com.core.springpractice;
import com.core.springpractice.member.Grade;
import com.core.springpractice.member.Member;
import com.core.springpractice.member.MemberService;
import com.core.springpractice.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "MemberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
