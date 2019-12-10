package be.mobyus.service;

import be.mobyus.service.domain.Order;
import be.mobyus.service.domain.OrderSearchCriteria;
import be.mobyus.service.domain.Product;

import java.util.Collection;

public interface OrderService {

    Collection<Order> findOrders(OrderSearchCriteria orderSearchCriteria);
}
