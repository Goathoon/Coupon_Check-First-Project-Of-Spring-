package Goat.CouponCheck.repository;

import Goat.CouponCheck.domain.Coupon;
import Goat.CouponCheck.domain.Member;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class JdbcRepository implements Repository{

    private final DataSource dataSource;

    public JdbcRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Member saveMember(Member member) {
        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }

    @Override
    public Optional<Integer> saveCoupon(Coupon coupon) {
        return Optional.empty();
    }
}