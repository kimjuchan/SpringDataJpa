package co.kr.jpa.springdatajpa.domain.compositekey;


import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Book - Library ( N : 1)     Book 외래 키를 가지고 있는 테이블 //연관관계 주인      Library : mappedBy를 가짐.
 * USER - UserGroup
 *
 */


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    private int id1;

    @Id
    private int id2;
}
