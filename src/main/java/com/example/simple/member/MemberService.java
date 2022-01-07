package com.example.simple.member;

public interface MemberService {
    void join(Member member);
    Member finMember(Long memberId);
}
