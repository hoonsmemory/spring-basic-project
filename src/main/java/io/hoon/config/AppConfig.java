package io.hoon.config;

import io.hoon.discount.DiscountPolicy;
import io.hoon.discount.RateDiscountPolicy;
import io.hoon.member.MemberRepository;
import io.hoon.member.MemberService;
import io.hoon.member.MemberServiceImpl;
import io.hoon.member.MemoryMemberRepository;
import io.hoon.order.OrderService;
import io.hoon.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.
 */
@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
