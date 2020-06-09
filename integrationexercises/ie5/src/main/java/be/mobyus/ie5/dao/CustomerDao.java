package be.mobyus.ie5.dao;

import be.mobyus.ie5.entities.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> findCustomers(String name, String firstName, String username);
    Customer loadCustomer(String username);
}
