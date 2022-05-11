package io.hoon.config;

import io.hoon.discount.DiscountPolicy;
import io.hoon.discount.RateDiscountPolicy;
import io.hoon.member.MemberRepository;
import io.hoon.member.MemberService;
import io.hoon.member.MemberServiceImpl;
import io.hoon.member.MemoryMemberRepository;
import io.hoon.order.OrderService;
import io.hoon.order.OrderServiceImpl;


/**
 * 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.
 */
public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
