package Goat.CouponCheck;

import Goat.CouponCheck.repository.JdbcRepository;
import Goat.CouponCheck.repository.Repository;
import Goat.CouponCheck.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(repository());
    }

    @Bean
    public Repository repository(){

//        return new MemoryRepository();
        return new JdbcRepository(dataSource);
    }
}
