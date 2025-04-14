package com.core.springpractice.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long id);
}
