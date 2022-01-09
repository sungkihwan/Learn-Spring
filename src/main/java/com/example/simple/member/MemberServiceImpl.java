package com.example.simple.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("this is custom name") -> 이렇게 이름을 커스텀해서 저장 가능
@Component // memberServiceImpl로 컴포넌트 스캔이 관리하는 map에 key저장
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired // ac.getBean(MemberRepository.class) -> 의존관계 자동 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member finMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
