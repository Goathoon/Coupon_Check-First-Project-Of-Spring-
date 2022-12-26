package Goat.CouponCheck.repository;

import hello.hellospring.domain.Coupon;
import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryRepository implements Repository{

    //Member 정보 저장 자료구조
    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member saveMember(Member member) {
        member.setId(++sequence);
        member.setCouponNum(0); //초기에는 쿠폰을 발급받지 않았으므로 0으로 set
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member->member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Coupon saveCoupon(Coupon coupon) {
        return null;
    }
}
