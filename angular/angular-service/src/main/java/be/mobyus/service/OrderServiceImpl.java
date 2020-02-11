package be.mobyus.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.mobyus.service.dao.OrderRepository;
import be.mobyus.service.domain.Order;
import be.mobyus.service.domain.OrderSearchCriteria;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Collection<Order> findOrders(OrderSearchCriteria orderSearchCriteria) {
		Collection<Order> orders = orderRepository.findOrders(orderSearchCriteria);
		orders.stream().forEach(o -> {
			Hibernate.initialize(o.getProducts());
			Hibernate.initialize(o.getUser());
		});

		return orders;
	}
}
