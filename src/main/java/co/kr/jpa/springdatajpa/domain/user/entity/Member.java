package co.kr.jpa.springdatajpa.domain.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;

    @Column(nullable = false)
    private String userName;

    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name="team_id",updatable = false,insertable = false)
    Team team;

    public void addTeam(Team team){
        this.team = team;
        team.getMemberList().add(this);
    }
}
