package co.kr.jpa.springdatajpa;

import co.kr.jpa.springdatajpa.domain.user.entity.Member;
import co.kr.jpa.springdatajpa.domain.user.entity.Team;
import co.kr.jpa.springdatajpa.domain.user.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SpringDataJpaApplicationTests {


	@Autowired
	private MemberRepository memberRepository;

	@Test
	@DisplayName("게시판 생성")
	public void saveMemberTest(){

		// given
		// Member
		Member mem = new Member();
		Team teamA = new Team();
		teamA.setTeamName("teamA");

		mem.setTeam(teamA);
		mem.setPhoneNumber("010-1234-1234");
		mem.setUserName("juchan");

		// when
		memberRepository.save(mem);

		Member members = memberRepository.findByPhoneNumber(mem.getPhoneNumber());

		// then
		assertThat(members).isNotNull();
		assertThat(members.getTeam()).isEqualTo(teamA.getTeamName());
	}


}
