package com.example.simple;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Configuration
// 컴포넌트 스캔 -> 컴포넌트 애노테이션이 붙은 대상들 자동으로 빈 등록
@ComponentScan(
        /**
         * 베이스 패키지에서 설정한 위치에서부터 컴포넌트 스캔 -> 특정 디렉토리만 설정가능 ex) member, order ... 여러개로도 사용가능
         * 디폴트인 경우 com.example.simple 본인이 있는 위치의 하위 패키지를 모두 본다. -> 일반적으로 Configuration 파일을 디렉토리 최상단에 둔다.
         * 스프링부트의 경우 @SpringBootApplication 애노테이션 안에 컴포넌트 스캔이 디폴트로 구성되어있다. 그래서 이렇게 따로 설정 안해도 됨
         * 컴포넌트 스캔의 대상들은 아래와 같다.
         * @Component
         * @Service
         * @Repository
         * @Controller
         * @Configuration
         * 일반적으로 스프링부트에 Controller, Service, Repository, Component는 모두 싱글톤으로 관리된다.
         * 물론 설정을 통해서 싱글톤이 아니라 객체를 계속 생성할 수 있으나 웹 서비스인 경우 대규모 트래픽으로
         * 거의 모든 부분이 싱글톤으로 관리된다고 보면 될 것 같다.
         * 따라서 멀티쓰레드의 동시성 문제를 해결하기 위해 해당 어노테이션이 있는 파일(객체)에서는 상태를 저장하지 않아야한다.
         * 만약 상태를 저장한다면 데이터가 꼬여서 아주 개판이 될 수 있다.
         * 실제로 KEY값이 중복되어 저장이 버튼을 눌렀는데도 저장이 안된다던가
         * 물건값이 다르게 계산된다던가 하는 문제가 발생할 수 있다.
         * **/

        /**
         * 아래는 스프링이 해당 어노테이션에 기능을 사용하니 참고하자.
         * @Service -> 서비스는 특별한 추가기능이 없고 개발자들간에 서비로직을 인식하는 어노테이션이라고 볼 수 있다.
         * @Repository -> 데이터 접근계층으로 인식하여 DB 익셉션을 스프링의 익셉션으로 변환해서 로그에 출력해준다.
         * @Controller -> 컨트롤러로 인식한다.
         * **/
        basePackages = {"com.example.simple.order", "com.example.simple.member"},
        // AppConfig 필터링 -> 실제 서비스에서는 사용할 일이 거의 없음..
        excludeFilters = @ComponentScan.Filter
                (type = FilterType.ANNOTATION,
                classes = Configuration.class)
)
public class AutoAppConfig {

}
