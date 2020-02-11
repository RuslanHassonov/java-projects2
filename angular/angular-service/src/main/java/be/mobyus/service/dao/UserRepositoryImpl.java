package be.mobyus.service.dao;

import be.mobyus.service.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public User get(String username) {
        return (User) entityManager.createQuery("from User where username = :username").setParameter("username", username).getSingleResult();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }
}
