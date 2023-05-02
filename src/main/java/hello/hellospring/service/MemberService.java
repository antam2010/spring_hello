package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    /**
     * 회원가입
     * @param member
     * @return id
     */
    public Long join(Member member) {
        validateDupleicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 중복체크
     * @param member
     */
    private void validateDupleicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m-> {
            throw new IllegalStateException("이미 존재하는 회원");
        });
    }

    /**
     * 전체 회원조회
     * @return
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
