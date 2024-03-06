/*
package co.kr.jpa.springdatajpa.config;

import co.kr.jpa.springdatajpa.domain.user.entity.Member;
import co.kr.jpa.springdatajpa.domain.user.entity.Team;
import co.kr.jpa.springdatajpa.domain.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class AppTestRunner implements ApplicationRunner {

    private final MemberRepository memberRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        Member mem = new Member();
        Team teamA = new Team();
        teamA.setTeamName("teamA");

        mem.setTeam(teamA);
        mem.setPhoneNumber("010-1234-1234");
        mem.setUserName("juchan");

        // when
        memberRepository.save(mem);

        Member members = memberRepository.findByPhoneNumber(mem.getPhoneNumber());





    }
}
*/
