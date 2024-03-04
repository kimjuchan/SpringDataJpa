package co.kr.jpa.springdatajpa.domain.stock;


import co.kr.jpa.springdatajpa.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Stock extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long quantity;

    private Long productId;

    @Version
    private Long version;


    public void decrease(final Long quantity){
        if(this.quantity - quantity < 0) throw new RuntimeException("재고가 부족합니다.");

        this.quantity = this.quantity - quantity;

    }
}
