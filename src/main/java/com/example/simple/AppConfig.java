package com.example.simple;

import com.example.simple.discount.DiscountPolicy;
import com.example.simple.discount.RateDiscountPolicy;
import com.example.simple.member.MemberRepository;
import com.example.simple.member.MemberService;
import com.example.simple.member.MemberServiceImpl;
import com.example.simple.member.MemoryMemberRepository;
import com.example.simple.order.OrderService;
import com.example.simple.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // 수동으로 등록 -> 스프링으로 자체적으로 싱글톤 객체로 관리
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

}
