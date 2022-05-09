package io.hoon.order;

import io.hoon.discount.DiscountPolicy;
import io.hoon.discount.FixDiscountPolicy;
import io.hoon.member.Member;
import io.hoon.member.MemberRepository;
import io.hoon.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
