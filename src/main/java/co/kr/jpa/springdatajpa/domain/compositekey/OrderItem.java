package co.kr.jpa.springdatajpa.domain.compositekey;

import jakarta.persistence.Id;

public class OrderItem {
    @Id
    private int order_id;

    @Id
    private int item_id;
}
