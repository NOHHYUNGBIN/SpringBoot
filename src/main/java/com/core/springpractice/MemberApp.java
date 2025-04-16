package com.core.springpractice;
import com.core.springpractice.member.Grade;
import com.core.springpractice.member.Member;
import com.core.springpractice.member.MemberService;
import com.core.springpractice.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl();

        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "MemberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
