package co.kr.jpa.springdatajpa.domain.order.repository;

import co.kr.jpa.springdatajpa.domain.order.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {
}
