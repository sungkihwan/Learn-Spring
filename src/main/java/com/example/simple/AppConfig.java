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
