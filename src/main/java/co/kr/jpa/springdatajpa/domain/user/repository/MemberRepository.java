package co.kr.jpa.springdatajpa.domain.user.repository;

import co.kr.jpa.springdatajpa.domain.user.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

    public Member findByPhoneNumber(String phoneNumber);

}
