package co.kr.jpa.springdatajpa.domain.order.entity;

import co.kr.jpa.springdatajpa.common.BaseEntity;
import co.kr.jpa.springdatajpa.common.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//Order 예약어에 있나봄.
public class Orders extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @Column(nullable = false)
    private String totalPayments;

    @Column(nullable = false)
    @Enumerated(value=EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(nullable = false)
    private String orderName;

    //oneToMany order_item
}
