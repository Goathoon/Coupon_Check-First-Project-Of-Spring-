package Goat.CouponCheck.service;

import Goat.CouponCheck.repository.MemoryRepository;
import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {

    MemberService memberService;
    MemoryRepository memoryRepository;

    @BeforeEach
    public void beforeEach(){
        memoryRepository =  new MemoryRepository();
        memberService = new MemberService(memoryRepository);
    }
    @AfterEach
    public void afterEach(){
        memoryRepository.clearStore();
    }
    @Test
    void join() {
        //given
        Member member  = new Member();
        member.setName("goat1");
        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(member.getId()).get(); //Optional로 반환되는거 get으로 member를 꺼냄
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        Member member2 = new Member();

        member1.setName("goat1");
        member2.setName("goat1");
        //when
        memberService.join(member1);
        IllegalStateException msg = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(msg.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        //        try{
//            memberService.join(member2);
//            fail();
//        }catch(IllegalStateException e ){
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.1");
//        }

        //then

    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}