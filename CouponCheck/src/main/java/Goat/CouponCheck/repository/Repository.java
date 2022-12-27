package Goat.CouponCheck.repository;

import hello.hellospring.domain.Member;
import hello.hellospring.domain.Coupon;
import java.util.List;
import java.util.Optional;

public interface Repository {
    //Member domain 관련 구현 repository
    Member saveMember(Member member); //회원 저장
    Optional<Member> findById(Long id); //id로 회원 찾기
    Optional<Member> findByName(String name); //name으로 회원 찾기
    List<Member> findAll(); //회원정보 모두출력

    //Coupon domain 관련 구현 repository
    Optional<Integer> saveCoupon(Coupon coupon); // 쿠폰 남은 개수 저장
}