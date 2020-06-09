package be.mobyus.ie5.dao;

import be.mobyus.ie5.entities.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> findProducts(String productName) {

        Query query = sessionFactory.getCurrentSession().createQuery("from Product p where p.name like :productName");

        return (List<Product>) query.setParameter("productName", productName + "%").getResultList();
    }
}
