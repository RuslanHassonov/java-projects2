package be.mobyus.service.dao;

import static javax.persistence.criteria.JoinType.INNER;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import be.mobyus.service.domain.Order;
import be.mobyus.service.domain.OrderSearchCriteria;
import be.mobyus.service.domain.Product;
import be.mobyus.service.domain.User;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Collection<Order> findOrders(OrderSearchCriteria orderSearchCriteria) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaQuery<Order> orderQuery = cb.createQuery(Order.class).distinct(true);

		Root<Order> order = orderQuery.from(Order.class);

		if (orderSearchCriteria.getProduct() != null) {

			if (orderSearchCriteria.getProduct().getId() != null) {
				Join<Order, Product> products = order.join("products", INNER);
				orderQuery.where(cb.and(cb.equal(products.get("id"), orderSearchCriteria.getProduct().getId())));
			} else if (isNotBlank(orderSearchCriteria.getProduct().getProductName())) {
				Join<Order, Product> products = order.join("products", INNER);
				orderQuery.where(cb.and(cb.like(products.get("productName"), orderSearchCriteria.getProduct().getProductName() + "%")));
			}
		}

		if (orderSearchCriteria.getUser() != null) {
			Join<Order, User> user = order.join("user", INNER);
			if (isNotBlank(orderSearchCriteria.getUser().getFirstName())) {
				orderQuery.where(cb.and(cb.equal(cb.lower(user.get("firstName")), orderSearchCriteria.getUser().getFirstName().toLowerCase())));
			}
			if (isNotBlank(orderSearchCriteria.getUser().getLastName())) {
				orderQuery.where(cb.and(cb.equal(cb.lower(user.get("lastName")), orderSearchCriteria.getUser().getLastName().toLowerCase())));
			}
		}

		if (orderSearchCriteria.getOrderMaxAmount() != null) {
			orderQuery.where(cb.and(cb.le(order.get("totalAmount"), orderSearchCriteria.getOrderMaxAmount())));
		}

		if (orderSearchCriteria.getOrderMinAmount() != null) {
			orderQuery.where(cb.and(cb.ge(order.get("totalAmount"), orderSearchCriteria.getOrderMinAmount())));
		}

		if (orderSearchCriteria.getOrderDate() != null) {
			orderQuery.where(cb.and(cb.equal(order.get("orderDate"), orderSearchCriteria.getOrderDate())));
		}

		return entityManager.createQuery(orderQuery).getResultList();
	}

	@Override
	public void save(Order order) {
		entityManager.persist(order);
	}
}
