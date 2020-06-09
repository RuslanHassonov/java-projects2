package be.mobyus.ie5.dao;

import be.mobyus.ie5.entities.Customer;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> findCustomers(String name, String firstName, String username) {
        CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
        Root<Customer> customerRoot = criteriaQuery.from(Customer.class);
        criteriaQuery.select(customerRoot);

        Collection<Predicate> predicates = new ArrayList<>();
        if (StringUtils.isNotBlank(name)) {
            predicates.add(criteriaBuilder.and(criteriaBuilder.equal(customerRoot.get("name"), name)));
        }

        if (StringUtils.isNotBlank(firstName)) {
            predicates.add(criteriaBuilder.and(criteriaBuilder.equal(customerRoot.get("firstName"), firstName)));
        }

        if (StringUtils.isNotBlank(username)) {
            predicates.add(criteriaBuilder.and(criteriaBuilder.equal(customerRoot.get("userName"), username)));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[]{}));

        return sessionFactory.getCurrentSession().createQuery(criteriaQuery).list();
    }

    @Override
    public Customer loadCustomer(String username) {
        return (Customer) sessionFactory.getCurrentSession().createQuery("from Customer where lower(username) = :username").setParameter("username", username.toLowerCase());
    }
}
