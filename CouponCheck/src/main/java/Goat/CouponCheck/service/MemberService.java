package Goat.CouponCheck.service;

import Goat.CouponCheck.repository.Repository;
import Goat.CouponCheck.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final Repository repository;

    @Autowired
    public MemberService(Repository repository) {
        this.repository = repository;
    }

    /* 회원가입 */
    public Long join(Member member){
        //중복회원 방지
        validateDuplicateMember(member);
        repository.saveMember(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        repository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /*전체 회원 조회*/
    public List <Member> findMembers(){
        return repository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return repository.findById(memberId);
    }
}