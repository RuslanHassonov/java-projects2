package be.mobyus.service.dao;

import be.mobyus.service.domain.Product;
import be.mobyus.service.spring.ServiceModuleConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.Collection;

import static org.testng.Assert.assertEquals;

@Test
@ContextConfiguration(classes = {ServiceModuleConfig.class})
public class ProductRepositoryTest extends AbstractTransactionalTestNGSpringContextTests {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;


    public void testFindProducts() {
        /*Product product = new Product();
        product.setProductDescription("1996 ID software anthology box set with cool stuff");
        product.setProductName("id anthology");
        product.setProductPrice(new BigDecimal("70.00"));
        entityManager.persist(product);
        entityManager.flush();
        entityManager.clear();

        Collection<Product> result = productRepository.findProducts("id");

        assertEquals(result.size(),1);
        Product fromDb = result.iterator().next();
        assertEquals(fromDb.getId(), product.getId());
        assertEquals(fromDb.getProductName(), "id anthology");
        assertEquals(fromDb.getProductDescription(), "1996 ID software anthology box set with cool stuff");
        assertEquals(fromDb.getProductPrice(), new BigDecimal("70.00"));*/
    }
}