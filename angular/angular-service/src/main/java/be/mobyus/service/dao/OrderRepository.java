package be.mobyus.service.dao;

import java.util.Collection;

import be.mobyus.service.domain.Order;
import be.mobyus.service.domain.OrderSearchCriteria;

public interface OrderRepository {

	Collection<Order> findOrders(OrderSearchCriteria orderSearchCriteria);

	void save(Order order);
}
