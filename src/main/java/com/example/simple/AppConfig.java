package com.example.simple;

import com.example.simple.discount.DiscountPolicy;
import com.example.simple.discount.FixDiscountPolicy;
import com.example.simple.discount.RateDiscountPolicy;
import com.example.simple.member.MemberRepository;
import com.example.simple.member.MemberService;
import com.example.simple.member.MemberServiceImpl;
import com.example.simple.member.MemoryMemberRepository;
import com.example.simple.order.OrderService;
import com.example.simple.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), new FixDiscountPolicy());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
