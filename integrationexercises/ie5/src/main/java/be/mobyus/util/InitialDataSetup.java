package be.mobyus.util;

import be.mobyus.ie5.entities.Customer;
import be.mobyus.ie5.entities.Product;
import org.hibernate.SessionFactory;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import be.mobyus.ie5.entities.Eshop;

import java.math.BigDecimal;

public class InitialDataSetup {

	private TransactionTemplate transactionTemplate;
	private SessionFactory sessionFactory;

	public InitialDataSetup(TransactionTemplate transactionTemplate, SessionFactory sessionFactory) {
		this.transactionTemplate = transactionTemplate;
		this.sessionFactory = sessionFactory;
	}

	public void initData() {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {

				// Setup test data

				// Eshop 1
				{
					Eshop eshop = new Eshop();
					eshop.setName("eShop 1");
					sessionFactory.getCurrentSession().save(eshop);
				}
				// Eshop 2
				{
					Eshop eshop = new Eshop();
					eshop.setName("The Bestest of Gattos");
					sessionFactory.getCurrentSession().save(eshop);
				}
				// Customer 1
				{
					Customer customer = new Customer();
					customer.setFirstName("Coco");
					customer.setName("The Cat");
					customer.setUserName("Coco");
					//customer1.setPassword(test);
					sessionFactory.getCurrentSession().save(customer);
				}
				// Customer 2
				{
					Customer customer = new Customer();
					customer.setFirstName("Yula");
					customer.setName("The Other Cat");
					customer.setUserName("Yula");
					//customer2.setPassword(test);
					sessionFactory.getCurrentSession().save(customer);
				}
				// Product 1
				{
					Product product = new Product();
					product.setName("Plushy Mouse Toy");
					product.setNumberInStock(72);
					product.setPrice(new BigDecimal("5.50"));
					product.setShortName("Tiny Mouse");
					sessionFactory.getCurrentSession().save(product);
				}
				// Product 2
				{
					Product product = new Product();
					product.setName("Plastic Ball with a Bell");
					product.setNumberInStock(10);
					product.setPrice(new BigDecimal("3.50"));
					product.setShortName("Ring-a-Ding");
					sessionFactory.getCurrentSession().save(product);
				}
				// Product 3
				{
					Product product = new Product();
					product.setName("Pet Brush for Long-Haired Pets");
					product.setNumberInStock(72);
					product.setPrice(new BigDecimal("15.99"));
					product.setShortName("Furmintator 5000");
					sessionFactory.getCurrentSession().save(product);
				}
				// Product 4
				{
					Product product = new Product();
					product.setName("Giant Cat Tower with Spring Loaded Mouse Launchers");
					product.setNumberInStock(72);
					product.setPrice(new BigDecimal("650.00"));
					product.setShortName("Climby & Scratchy Paradise");
					sessionFactory.getCurrentSession().save(product);
				}
				// Product 5
				{
					Product product = new Product();
					product.setName("Food Bowl with a Build-In Cheek Rubber");
					product.setNumberInStock(72);
					product.setPrice(new BigDecimal("105.35"));
					product.setShortName("Rub-A-Dub XL");
					sessionFactory.getCurrentSession().save(product);
				}


			}
		});
	}

	public void tearDown() {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
			}
		});
	}
}
