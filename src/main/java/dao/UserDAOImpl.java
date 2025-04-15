package dao;


import jakarta.persistence.*;

import model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManagerFactory managerFactory;

    @Override
    public void add(User user) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = managerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
        } catch (Exception e) {
            if (entityManager != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error when the user saved");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void delete(User user) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = managerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(user);
            transaction.commit();
        } catch (Exception e) {
            if (entityManager != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error when the user deleted");
        } finally {
            entityManager.close();
        }
    }


    public void edit(User user, int userId) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = managerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            User existingUser = entityManager.find(User.class, userId);
            if (existingUser == null) {
                throw new IllegalArgumentException("User not found");
            }

            existingUser.setName(user.getName());
            existingUser.setSurname(user.getSurname());
            existingUser.setAge(user.getAge());

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error when the user updated", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public List<User> viewAllUsers() {
        EntityManager entityManager = null;

        try {
            entityManager = managerFactory.createEntityManager();
            // Транзакция не нужна для операций только чтения
            String jpql = "SELECT u FROM User u";
            TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
            return query.getResultList();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }


    }
}