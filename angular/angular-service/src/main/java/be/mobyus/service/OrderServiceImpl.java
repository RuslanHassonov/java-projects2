package be.mobyus.service;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import be.mobyus.service.domain.Order;
import be.mobyus.service.domain.OrderSearchCriteria;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Override
	public Collection<Order> findOrders(OrderSearchCriteria orderSearchCriteria) {
		return new ArrayList<>();
	}
}
