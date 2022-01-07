package com.example.simple.member;

import com.example.simple.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        memberService = applicationContext.getBean("memberService", MemberService.class);
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
