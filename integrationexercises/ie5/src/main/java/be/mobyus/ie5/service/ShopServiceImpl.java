package be.mobyus.ie5.service;

import java.util.List;

import be.mobyus.ie5.dao.CustomerDao;
import be.mobyus.ie5.dao.OrderDao;
import be.mobyus.ie5.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.mobyus.ie5.dao.ShopDao;
import be.mobyus.ie5.entities.Customer;
import be.mobyus.ie5.entities.Eshop;
import be.mobyus.ie5.entities.Order;
import be.mobyus.ie5.entities.Product;

@Service
@Transactional
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDao shopDao;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private OrderDao orderDao;

	@Override
	@SuppressWarnings("unchecked")
	public List<Eshop> listEshops() {
		return shopDao.listAllShops();
	}

	@Override
	public Eshop loadShop(Long shopId) {
		return shopDao.loadShop(shopId);
	}

	@Override
	public Customer loadCustomer(String username) {
		return customerDao.loadCustomer(username);
	}

	@Override
	public void createOrder(List<Product> products) {
		// TODO complete me
	}

	@Override
	public List<Product> listProducts(String name) {
		return productDao.findProducts(name);
	}

	@Override
	public List<Order> listOrders(Customer customer) {
		return orderDao.findOrdersForCustomer(customer);
	}
}
