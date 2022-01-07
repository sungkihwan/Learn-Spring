package com.example.simple.member;

import com.example.simple.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {

        Member member1 = new Member(1L, "member1", Grade.VIP);
        memberService.join(member1);

        Member findMember = memberService.finMember(1l);

        Assertions.assertThat(member1).isEqualTo(findMember);

        System.out.println(member1.getName());
        System.out.println(findMember.getName());
    }
}
