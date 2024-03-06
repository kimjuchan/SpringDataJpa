package co.kr.jpa.springdatajpa.common.specification;

import co.kr.jpa.springdatajpa.domain.order.entity.Orders;
import co.kr.jpa.springdatajpa.domain.order.repository.OrderRepository;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class SearchSepcification<T> {

    private OrderRepository orderRepository;

    public SearchSepcification(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //orderName
    public Specification<T> equalOrderName(String orderName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("orderName"), orderName);
    }


    public List<Orders> findOrders(String orderName){
        List<Orders> orders  = orderRepository.findAll();
        return orders;

    }


}
