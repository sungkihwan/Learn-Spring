package com.example.simple.beantest;

import com.example.simple.AppConfig;
import com.example.simple.member.MemberService;
import com.example.simple.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력")
    void findAllBeans() {
        String[] beanList = ac.getBeanDefinitionNames();
        for (String beanName : beanList) {
            Object bean = ac.getBean(beanName);
            System.out.println("bean = " + beanName + ", object = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력")
    void findAppBeans() {
        String[] beanList = ac.getBeanDefinitionNames();
        for (String beanName : beanList) {
            BeanDefinition beanDef = ac.getBeanDefinition(beanName);

            // ROLE_APPLICATION: 직접 등록한 애플리케이션 빈만 출력
            // ROLE_INFRASTRUCTURE: 스프링이 관리하는 빈
            if (beanDef.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanName);
                System.out.println("bean = " + beanName + ", object = " + bean);
            }
        }
    }

    @Test
    @DisplayName("빈 조회")
    void findBeanName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        System.out.println("memberService = " + memberService);
        System.out.println("memberService.getClass() = " + memberService.getClass());

        MemberServiceImpl memberService2 = ac.getBean(MemberServiceImpl.class);
        System.out.println("memberService2 = " + memberService2);
        System.out.println("memberService2.getClass() = " + memberService2.getClass());

        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }

}
