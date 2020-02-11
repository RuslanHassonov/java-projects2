package be.mobyus.service.dao;

import be.mobyus.service.domain.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collection;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Repository
public class ProductRepositoryImpl  implements ProductRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Collection<Product> findProducts(String productName) {
        if(isBlank(productName)){
            return new ArrayList<>();
        }

        return entityManager.createQuery("from Product p where lower(p.productName) like :productName").setParameter("productName", "%"+productName.toLowerCase()+"%").getResultList();
    }
}
