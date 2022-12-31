package Goat.CouponCheck.repository;

import Goat.CouponCheck.domain.Coupon;
import Goat.CouponCheck.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaRepository extends JpaRepository<Member,Long>,Repository {
    @Override
     
    Optional<Integer> saveCoupon(Coupon coupon); //여기서 문제
}
