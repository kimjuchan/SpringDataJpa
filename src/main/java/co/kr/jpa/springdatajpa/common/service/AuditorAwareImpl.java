package co.kr.jpa.springdatajpa.common.service;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;


public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        //임시 userName 생성.
        //추후 로그인 사용자 정보 가져와야함.
        return Optional.of("userA");
    }
}
