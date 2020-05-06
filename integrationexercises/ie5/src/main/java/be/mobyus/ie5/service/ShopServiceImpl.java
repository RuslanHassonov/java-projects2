package be.mobyus.ie5.service;

import java.util.List;

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

	@Override
	@SuppressWarnings("unchecked")
	public List<Eshop> listEshops() {
		return shopDao.listAllShops();
	}

	@Override
	public Eshop loadShop(Long shopId) {
		// TODO complete me
		return null;
	}

	@Override
	public Customer loadCustomer(String username) {
		// TODO complete me
		return null;
	}

	@Override
	public void createOrder(List<Product> products) {
		// TODO complete me
	}

	@Override
	public List<Product> listProducts(String name) {
		// TODO complete me
		return null;
	}

	@Override
	public List<Order> listOrders(Customer customer) {
		// TODO complete me
		return null;
	}
}
