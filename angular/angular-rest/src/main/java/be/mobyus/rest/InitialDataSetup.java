package be.mobyus.rest;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import be.mobyus.service.dao.OrderRepository;
import be.mobyus.service.dao.UserRepository;

@Component
public class InitialDataSetup {

	@Autowired
	private PlatformTransactionManager platformTransactionManager;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostConstruct
	public void setup() {
		TransactionTemplate transactionTemplate = new TransactionTemplate(platformTransactionManager);
		transactionTemplate.execute(e -> {

		/*	User user = new User();
			user.setFirstName("John");
			user.setLastName("Doe");
			user.setUsername("john");

			user.setPassword(passwordEncoder.encode("doe"));
			userRepository.save(user);

			Order order = new Order();
			order.setOrderDate(new Date());
			order.setUser(user);

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
			orderRepository.save(order);*/

			return null;
		});
	}
}