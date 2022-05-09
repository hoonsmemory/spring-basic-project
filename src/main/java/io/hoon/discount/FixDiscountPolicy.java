package io.hoon.discount;

import io.hoon.member.Grade;
import io.hoon.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private static int discountFixAmount = 1000;//할인 고정금액

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }
        return 0;
    }
}
