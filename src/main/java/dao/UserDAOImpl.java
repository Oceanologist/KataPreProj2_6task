package dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transaction;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDao {
    @Autowired
    private EntityManagerFactory managerFactory;

    @Override
    public void add(User user) {
        EntityManager entityManager=managerFactory.createEntityManager();
        EntityTransaction transaction =entityManager.getTransaction();
        entityManager.persist(user);
        transaction.commit();
        entityManager.close();

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void edit(User user) {

    }

    @Override
    public User findById(int id) {
        return null;
    }
}
