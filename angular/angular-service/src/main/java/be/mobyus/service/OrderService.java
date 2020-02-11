package be.mobyus.service;

import java.util.Collection;

import be.mobyus.service.domain.Order;
import be.mobyus.service.domain.OrderSearchCriteria;

public interface OrderService {

	Collection<Order> findOrders(OrderSearchCriteria orderSearchCriteria);
}
