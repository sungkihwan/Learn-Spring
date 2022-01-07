package com.example.simple.discount;

import com.example.simple.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
