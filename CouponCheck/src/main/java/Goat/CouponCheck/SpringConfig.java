package Goat.CouponCheck;

import Goat.CouponCheck.repository.MemoryRepository;
import Goat.CouponCheck.repository.Repository;
import Goat.CouponCheck.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService(){
        return new MemberService(repository());
    }

    @Bean
    public Repository repository(){
        return new MemoryRepository();
    }
}
