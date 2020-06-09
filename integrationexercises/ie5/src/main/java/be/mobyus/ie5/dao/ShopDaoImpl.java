package be.mobyus.ie5.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import be.mobyus.ie5.entities.Eshop;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ShopDaoImpl implements ShopDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Eshop> listAllShops() {
        return sessionFactory.getCurrentSession().createQuery("from Eshop").list();
    }

    @Override
    public Eshop loadShop(Long shopId) {
        return (Eshop) sessionFactory.getCurrentSession().createQuery("from Eshop where id = :shopId").setParameter("shopId", shopId);
    }


}
