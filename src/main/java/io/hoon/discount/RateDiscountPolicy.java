package io.hoon.discount;

import io.hoon.annotation.MainDiscountPolicy;
import io.hoon.member.Grade;
import io.hoon.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    private static int discountPercent = 10;// 10% 활인

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return (price * discountPercent) / 100;
        }

        return 0;
    }
}
