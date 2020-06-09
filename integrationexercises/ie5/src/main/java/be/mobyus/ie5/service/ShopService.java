package be.mobyus.ie5.service;

import java.util.List;

import be.mobyus.ie5.entities.Customer;
import be.mobyus.ie5.entities.Eshop;
import be.mobyus.ie5.entities.Order;
import be.mobyus.ie5.entities.Product;
import org.springframework.stereotype.Service;

@Service
public interface ShopService {

	public List<Eshop> listEshops();

	public Eshop loadShop(Long shopId);

	public Customer loadCustomer(String username);

	public void createOrder(List<Product> products);

	public List<Product> listProducts(String name);

	public List<Order> listOrders(Customer customer);

}
