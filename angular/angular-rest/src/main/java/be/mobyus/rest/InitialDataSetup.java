package be.mobyus.rest;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import be.mobyus.service.dao.OrderRepository;
import be.mobyus.service.dao.UserRepository;
import be.mobyus.service.domain.Order;
import be.mobyus.service.domain.Product;
import be.mobyus.service.domain.User;

@Component
public class InitialDataSetup {

	@Autowired
	private PlatformTransactionManager platformTransactionManager;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserRepository userRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostConstruct
	public void setup() {
		TransactionTemplate transactionTemplate = new TransactionTemplate(platformTransactionManager);
		transactionTemplate.execute(e -> {

			User john = new User();
			john.setFirstName("John");
			john.setLastName("Doe");
			john.setUsername("john");

			john.setPassword(passwordEncoder.encode("doe"));
			userRepository.save(john);

			{
				Order order = new Order();
				order.setOrderDate(new Date());
				order.setUser(john);

				Product product = new Product();
				product.setProductDescription("1996 ID software anthology box set with cool stuff");
				product.setProductName("id anthology");
				product.setProductPrice(new BigDecimal("70.00"));
				order.getProducts().add(product);

				product = new Product();
				product.setProductDescription("IphoneXX");
				product.setProductName("IphoneXX");
				product.setProductPrice(new BigDecimal("7000.00"));
				order.getProducts().add(product);

				product = new Product();
				product.setProductDescription("Brooddoos");
				product.setProductName("Brooddoos");
				product.setProductPrice(new BigDecimal("7.15"));
				order.getProducts().add(product);

				order.setTotalAmount(order.getProducts().stream().map(p -> p.getProductPrice()).reduce((i, a) -> a.add(i)).get());
				orderRepository.save(order);
			}

			User orderAlot = new User();
			orderAlot.setFirstName("Order");
			orderAlot.setLastName("Alot");
			orderAlot.setUsername("order");
			orderAlot.setPassword(passwordEncoder.encode("alot"));
			userRepository.save(orderAlot);
			{
				Product product = new Product();
				product.setProductDescription("Lego technic 42100");
				product.setProductName("Lego technic 42100");
				product.setProductPrice(new BigDecimal("380.00"));
				entityManager.persist(product);

				for (int i = 0; i < 100; i++) {
					Order order = new Order();
					order.setOrderDate(new Date());
					order.setUser(orderAlot);
					order.getProducts().add(product);
					order.setTotalAmount(order.getProducts().stream().map(p -> p.getProductPrice()).reduce((x, a) -> a.add(x)).get());
					orderRepository.save(order);
				}
			}

			return null;
		});
	}
}