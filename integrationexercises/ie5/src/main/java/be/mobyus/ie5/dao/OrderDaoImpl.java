package be.mobyus.ie5.dao;

import be.mobyus.ie5.entities.Customer;
import be.mobyus.ie5.entities.Order;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;

@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Order> findOrdersForCustomer(Customer customer) {
        return sessionFactory.getCurrentSession().createQuery("from Customer where lower(username) = :username").setParameter("username", customer.getUserName().toLowerCase()).list();
    }

    @Override
    public void saveOrder(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }
}
