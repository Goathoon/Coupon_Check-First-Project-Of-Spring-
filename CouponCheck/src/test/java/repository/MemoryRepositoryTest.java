package repository;

import Goat.CouponCheck.repository.MemoryRepository;
import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import hello.hellospring.domain.Coupon;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryRepositoryTest {
    MemoryRepository repository = new MemoryRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        hello.hellospring.domain.Member member = new Member();
        member.setName("goat");

        repository.saveMember(member);
        Member result = repository.findById(member.getId()).get();

        //Assertions.assertEquals(member,result);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("hoon1");
        repository.saveMember(member1);

        Member member2 = new Member();
        member2.setName("hoon2");
        repository.saveMember(member2);

        Member result = repository.findByName("hoon1").get();

        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("hoon1");
        repository.saveMember(member1);

        Member member2 = new Member();
        member2.setName("hoon2");
        repository.saveMember(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
    @Test
    public void saveCoupon(){
        Coupon coupon = new Coupon();
        coupon.setNum();
        assertThat(coupon.getNum()).isEqualTo(9);
    }

    //coupon 0 개 예외 추가 테스트 작성할것.
    @Test
    public void saveOverCoupon(){
        Coupon coupon = new Coupon();
        for (int i = 0; i<11; i++){
            coupon.setNum();
        }
        assertThat(coupon.getNum()).isEqualTo(null);
    }
}
