package co.kr.jpa.springdatajpa.config;


import co.kr.jpa.springdatajpa.common.service.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//속성값으로 등록해준다는데   아직 정확하게 이해 안감.
@Configuration
@EnableJpaAuditing(auditorAwareRef="audiorProvider")
public class JpaAuditConfig {
    @Bean
    AuditorAware<String> auditorProvider() {
        //AuditorAware 인터페이스 구현체
        return new AuditorAwareImpl();
    }
}
