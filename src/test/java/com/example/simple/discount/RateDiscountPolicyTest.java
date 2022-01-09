package com.example.simple.discount;

import com.example.simple.AppConfig;
import com.example.simple.member.Grade;
import com.example.simple.member.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy;

    @BeforeEach
    public void before() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        discountPolicy = applicationContext.getBean("discountPolicy", DiscountPolicy.class);
    }

    @Test
    @DisplayName("junit5 부터 적용되는 디스플레이 네임")
    void test() {
        Member member = new Member(1L, "MemberVIP", Grade.VIP);
        int discount = discountPolicy.discount(member, 10000);
        assertThat(discount).isEqualTo(1000);
    }

}