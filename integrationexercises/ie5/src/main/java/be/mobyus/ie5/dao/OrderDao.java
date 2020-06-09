package be.mobyus.ie5.dao;

import be.mobyus.ie5.entities.Customer;
import be.mobyus.ie5.entities.Order;

import java.util.List;

public interface OrderDao {

    List<Order> findOrdersForCustomer(Customer customer);
    void saveOrder(Order order);
}
