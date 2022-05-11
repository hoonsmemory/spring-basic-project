package io.hoon.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    /**
     * 생성자 주입 - 의존관계에 대한 고민은 외부에 맡긴다.
     */
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public void join(Member member) {
        memberRepository.save(member);
    }
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
