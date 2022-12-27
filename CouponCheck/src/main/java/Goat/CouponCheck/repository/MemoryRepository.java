package Goat.CouponCheck.repository;

import Goat.CouponCheck.domain.Coupon;
import Goat.CouponCheck.domain.Member;

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
    public Optional<Integer> saveCoupon(Coupon coupon) {
        coupon.setNum();
        Optional<Integer> returnVal = Optional.ofNullable(coupon.getNum());
        if (returnVal.isPresent()){
            return Optional.ofNullable(coupon.getNum());
        }
        else{
            System.err.println("쿠폰수가 0장입니다.");
            return Optional.ofNullable(coupon.getNum());
        }
    }
    public void clearStore(){
        store.clear();
    }
}
