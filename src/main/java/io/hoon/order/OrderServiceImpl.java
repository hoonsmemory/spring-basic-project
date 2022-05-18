package io.hoon.order;

import io.hoon.discount.DiscountPolicy;
import io.hoon.discount.FixDiscountPolicy;
import io.hoon.discount.RateDiscountPolicy;
import io.hoon.member.Member;
import io.hoon.member.MemberRepository;
import io.hoon.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrderServiceImpl implements OrderService {

    /**
     * DIP 위반(인터페이스만 의존해야한다.)
     * 인터페이스뿐만 아니라 구체 클래스도 의존하고 있다.
     *
     * OCP 위반(변경하지 않고 확장이 가능해야 한다.)
     * FixDiscountPolicy -> RateDiscountPolicy 변경하기 위해 소스를 수정해야 하므로...
     *
     * private final MemberRepository memberRepository = new MemoryMemberRepository();
     * private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
     * private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
     */

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
