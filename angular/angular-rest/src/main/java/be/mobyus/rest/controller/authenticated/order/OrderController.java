package be.mobyus.rest.controller.authenticated.order;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.mobyus.service.OrderService;
import be.mobyus.service.domain.Order;
import be.mobyus.service.domain.OrderSearchCriteria;

@RestController
@RequestMapping("authenticated/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(path = "findOrders", method = POST, consumes = "application/json", produces = "application/json")
	public Collection<Order> findOrders(@RequestBody OrderSearchCriteria orderSearchCriteria) {
		return orderService.findOrders(orderSearchCriteria);
	}
}
