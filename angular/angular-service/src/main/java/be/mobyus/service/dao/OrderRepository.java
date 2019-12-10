package be.mobyus.service.dao;

import be.mobyus.service.domain.Order;
import be.mobyus.service.domain.OrderSearchCriteria;

import java.util.Collection;

public interface OrderRepository {

    Collection<Order> findOrders(OrderSearchCriteria orderSearchCriteria);

    void save(Order order);
}
