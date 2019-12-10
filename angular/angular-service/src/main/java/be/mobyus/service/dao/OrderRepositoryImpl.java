package be.mobyus.service.dao;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Repository;

import be.mobyus.service.domain.Order;
import be.mobyus.service.domain.OrderSearchCriteria;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

	@Override
	public Collection<Order> findOrders(OrderSearchCriteria orderSearchCriteria) {
		return new ArrayList<>();
	}

	@Override
	public void save(Order order) {
	}
}
