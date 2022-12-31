package Goat.CouponCheck;

import Goat.CouponCheck.repository.Repository;
import Goat.CouponCheck.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
//    private DataSource dataSource;
//    private EntityManager em;
    private final Repository repository;

//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
    @Autowired
    public SpringConfig(Repository repository){
        this.repository = repository;
    }
    @Bean
    public MemberService memberService(){

//        return new MemberService(repository());
        return new MemberService(repository);
    }

//    @Bean
//    public Repository repository(){
//
////        return new MemoryRepository();
////        return new JdbcRepository(dataSource);
////        return new JdbcTemplateRepository(dataSource);
////        return new JpaRepository(em);
//
//    };


}
